package com.motors.gm.configs;

import java.util.Base64;
import java.util.Date;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.motors.gm.model.Role;
import com.motors.gm.service.CustomUserDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

	//variables and injected bean inside the class 
	@Value("${security.jwt.token.secret-key:secret}")
	private String secretKey = "secret";

	//variables and injected bean inside the class 000
	@Value("${security.jwt.token.expire-length:3600000}")
	private long validityInMilliseconds = 3600000; // 1h

	//variables and injected bean inside the class 
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	//method for initialisation.
	@PostConstruct
	protected void init() {
	    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	//method to create a JWT token.
	public String createToken(String username, Set<Role> set) {
	    Claims claims = Jwts.claims().setSubject(username);
	    claims.put("roles", set);
	    Date now = new Date();
	    Date validity = new Date(now.getTime() + validityInMilliseconds);
	    return Jwts.builder()//
	        .setClaims(claims)//
	        .setIssuedAt(now)//
	        .setExpiration(validity)//
	        .signWith(SignatureAlgorithm.HS256, secretKey)//
	        .compact();
	}
	
	//method to load User by username.
	public Authentication getAuthentication(String token) {
	    UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
	    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	//method to get the username by JWT token.
	public String getUsername(String token) {
	    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}
	
	//method to resolve JWT token from request headers of Authorization that has a Bearer prefix.
	public String resolveToken(HttpServletRequest req) {
	    String bearerToken = req.getHeader("Authorization");
	    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
	        return bearerToken.substring(7, bearerToken.length());
	    }
	    return null;
	}
	
	//method to validate a JWT token
	public boolean validateToken(String token) {
	    try {
	        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
	        if (claims.getBody().getExpiration().before(new Date())) {
	            return false;
	        }
	        return true;
	    } catch (JwtException | IllegalArgumentException e) {
	        throw new JwtException("Expired or invalid JWT token");
	    }
	}
	
}

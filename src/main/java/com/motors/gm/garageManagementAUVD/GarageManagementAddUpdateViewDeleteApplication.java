package com.motors.gm.garageManagementAUVD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.motors.gm.model.Role;
import com.motors.gm.repository.RoleRepository;

@SpringBootApplication
@ComponentScan({"com.motors.gm"})
@EntityScan("com.motors.gm")
@EnableMongoRepositories("com.motors.gm")
public class GarageManagementAddUpdateViewDeleteApplication extends SpringBootServletInitializer{

	private static final Logger LOGGER = LogManager.getLogger(GarageManagementAddUpdateViewDeleteApplication.class.getName());
	
	//Added below method for RBCA
	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {

	    return args -> {

	        Role adminRole = roleRepository.findByRole("ADMIN");
	        if (adminRole == null) {
	            Role newAdminRole = new Role();
	            newAdminRole.setRole("ADMIN");
	            roleRepository.save(newAdminRole);
	        }
	    };

	}
	
	public static void main(String[] args) {
		SpringApplication.run(GarageManagementAddUpdateViewDeleteApplication.class, args);
		LOGGER.debug("Garage Management Add Update View Delete Vehicle Model Rest API Service");
		
	}

}

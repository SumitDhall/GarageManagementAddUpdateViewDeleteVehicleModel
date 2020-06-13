package com.motors.gm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.motors.gm.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	User findByEmail(String email);

}

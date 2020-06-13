package com.motors.gm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.motors.gm.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	Role findByRole(String role);
}

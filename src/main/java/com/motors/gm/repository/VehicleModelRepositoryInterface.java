package com.motors.gm.repository;

import org.springframework.data.repository.CrudRepository;

import com.motors.gm.model.VehicleModel;

public interface VehicleModelRepositoryInterface extends CrudRepository<VehicleModel, String>{

	/* Adding below delete method to implement RBCA*/
	@Override
	void delete(VehicleModel delete);
	
	
	
}

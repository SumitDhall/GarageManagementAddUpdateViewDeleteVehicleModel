package com.motors.gm.service;

import java.util.List;

import com.motors.gm.exception.ActorNotFoundException;
import com.motors.gm.model.VehicleModel;


public interface VehicleModelAddUpdateViewDeleteService {
	
	public String saveVehicle(VehicleModel vehicleModel);
	public void updateVehicle(VehicleModel vehicleModel, String regNumber) throws ActorNotFoundException;
	public String deleteVehicle(String regNumber);
	List<VehicleModel> findAllVehicle();
	List<VehicleModel> findVehicleByRegNumber(String regNumber) throws ActorNotFoundException;
	List<VehicleModel> findVehicleByFeaturesVehicleDetails(VehicleModel vehicleModel);

}
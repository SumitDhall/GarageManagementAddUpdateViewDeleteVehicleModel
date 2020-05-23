package com.motors.gm.service;

import java.util.List;

import com.motors.gm.model.VehicleModel;


public interface VehicleModelAddUpdateViewDeleteService {
	
	public void saveVehicle(VehicleModel vehicleModel);
	public void updateVehicle(VehicleModel vehicleModel, String regNumber);
	public String deleteVehicle(String regNumber);
	List<VehicleModel> findAllVehicle();
	List<VehicleModel> findVehicleByRegNumber(String regNumber);
	List<VehicleModel> findVehicleByFeaturesVehicleDetails(VehicleModel vehicleModel);

}
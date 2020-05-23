package com.motors.gm.repository;

import java.util.List;

import com.motors.gm.model.VehicleModel;

public interface VehicleModelAddUpdateViewDeleteRepository {

	//List<VehicleModel> addVehicle();

	//void saveVehicle(TestModel testModel);

	public String saveVehicle(VehicleModel vehicleModel);
	public VehicleModel updateVehicle(VehicleModel vehicleModel, String regNumber);
	public String deleteVehicle(String regNumber);
	public  List<VehicleModel> findAllVehicle();
	public List<VehicleModel> findVehicleByRegNumber(String regNumber);
	//List<VehicleModel> findVehicleByFeaturesVehicleDetails(List vehicleModelList);
	List<VehicleModel> findVehicleByFeaturesVehicleDetails(VehicleModel vehicleModel);
}
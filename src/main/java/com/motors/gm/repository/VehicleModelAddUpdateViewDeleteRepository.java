package com.motors.gm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.motors.gm.exception.ActorNotFoundException;
import com.motors.gm.model.VehicleModel;

//extended interface CrudRepository as part of the RBCA
public interface VehicleModelAddUpdateViewDeleteRepository //extends CrudRepository<VehicleModel, String>
{

	//List<VehicleModel> addVehicle();

	//void saveVehicle(TestModel testModel);

	public String saveVehicle(VehicleModel vehicleModel);
	public VehicleModel updateVehicle(VehicleModel vehicleModel, String regNumber) throws ActorNotFoundException;
	public String deleteVehicle(String regNumber);
	public  List<VehicleModel> findAllVehicle();
	public List<VehicleModel> findVehicleByRegNumber(String regNumber) throws ActorNotFoundException;
	//List<VehicleModel> findVehicleByFeaturesVehicleDetails(List vehicleModelList);
	List<VehicleModel> findVehicleByFeaturesVehicleDetails(VehicleModel vehicleModel);
	
	
}
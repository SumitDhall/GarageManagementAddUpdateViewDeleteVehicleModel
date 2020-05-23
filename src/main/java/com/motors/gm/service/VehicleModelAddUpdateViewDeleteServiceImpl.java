package com.motors.gm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.motors.gm.model.VehicleModel;
import com.motors.gm.repository.VehicleModelAddUpdateViewDeleteRepository;

@Service
public class VehicleModelAddUpdateViewDeleteServiceImpl implements VehicleModelAddUpdateViewDeleteService {

	@Autowired
	VehicleModelAddUpdateViewDeleteRepository vehicleModelAddUpdateViewRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	public void saveVehicle(VehicleModel vehicleModel) {
		vehicleModelAddUpdateViewRepository.saveVehicle(vehicleModel);
		System.out.println("Vehicle Repository to save new vehicle called");
	}

	@Override
	public void updateVehicle(VehicleModel vehicleModel, String regNumber) {

		vehicleModelAddUpdateViewRepository.updateVehicle(vehicleModel, regNumber);
		System.out.println("Vehicle Repository to update vehicle called");
	}

	@Override
	public String deleteVehicle(String regNumber) {
		System.out.println("Vehicle Repository to delete vehicle called");
		return vehicleModelAddUpdateViewRepository.deleteVehicle(regNumber);
	}

	@Override
	public List<VehicleModel> findAllVehicle() {

		System.out.println("Vehicle view Repository to find all vehicle");
		return vehicleModelAddUpdateViewRepository.findAllVehicle();
	}

	@Override
	public List<VehicleModel> findVehicleByRegNumber(String regNumber) {

		System.out.println("Vehicle view Repository to find all vehicle");
		return vehicleModelAddUpdateViewRepository.findVehicleByRegNumber(regNumber);
	}

	@Override
	public List<VehicleModel> findVehicleByFeaturesVehicleDetails(VehicleModel vehicleModel) {

		System.out.println("Vehicle view Repository to find vehicle with features");
		
//		List VehicleModelList = new ArrayList<VehicleModel>();
//		if (vehicleModel.getMake() != null) {
//			VehicleModelList.add(vehicleModel.getMake());
//		}
//		if (vehicleModel.getModel() != null) {
//			VehicleModelList.add(vehicleModel.getModel());
//		}
//		if (vehicleModel.getGearBox() != null) {
//			VehicleModelList.add(vehicleModel.getGearBox());
//		}
		
		return vehicleModelAddUpdateViewRepository.findVehicleByFeaturesVehicleDetails(vehicleModel);
		//return vehicleModelAddUpdateViewRepository.findVehicleByFeaturesVehicleDetails(VehicleModelList);
	}

}

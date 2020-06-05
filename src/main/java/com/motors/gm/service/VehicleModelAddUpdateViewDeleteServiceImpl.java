package com.motors.gm.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.motors.gm.exception.ActorNotFoundException;
import com.motors.gm.model.VehicleModel;
import com.motors.gm.repository.VehicleModelAddUpdateViewDeleteRepository;

@Service
public class VehicleModelAddUpdateViewDeleteServiceImpl implements VehicleModelAddUpdateViewDeleteService {

	private static final Logger LOGGER = LogManager.getLogger(VehicleModelAddUpdateViewDeleteServiceImpl.class.getName());
	
	@Autowired
	VehicleModelAddUpdateViewDeleteRepository vehicleModelAddUpdateViewRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	public String saveVehicle(VehicleModel vehicleModel) {
		String result = vehicleModelAddUpdateViewRepository.saveVehicle(vehicleModel);
		LOGGER.info("Vehicle Repository to save new vehicle called");
		return result;
	}

	@Override
	public void updateVehicle(VehicleModel vehicleModel, String regNumber) throws ActorNotFoundException {

		vehicleModelAddUpdateViewRepository.updateVehicle(vehicleModel, regNumber);
		LOGGER.info("Vehicle Repository to update vehicle called");
	}

	@Override
	public String deleteVehicle(String regNumber) {
		LOGGER.info("Vehicle Repository to delete vehicle called");
		return vehicleModelAddUpdateViewRepository.deleteVehicle(regNumber);
	}

	@Override
	public List<VehicleModel> findAllVehicle() {

		LOGGER.info("Vehicle view Repository to find all vehicle");
		return vehicleModelAddUpdateViewRepository.findAllVehicle();
	}

	@Override
	public List<VehicleModel> findVehicleByRegNumber(String regNumber){

		LOGGER.info("Vehicle view Repository to find all vehicle");
		return vehicleModelAddUpdateViewRepository.findVehicleByRegNumber(regNumber);
	}

	@Override
	public List<VehicleModel> findVehicleByFeaturesVehicleDetails(VehicleModel vehicleModel) {

		LOGGER.info("Vehicle view Repository to find vehicle with features");
		
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

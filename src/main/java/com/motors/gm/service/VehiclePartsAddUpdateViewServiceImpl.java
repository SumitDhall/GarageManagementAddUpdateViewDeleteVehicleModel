
package com.motors.gm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.motors.gm.model.VehicleModel;
import com.motors.gm.model.VehicleParts;
import com.motors.gm.repository.VehicleModelAddUpdateViewDeleteRepository;
import com.motors.gm.repository.VehiclePartsAddUpdateViewRepository;

@Service
public class VehiclePartsAddUpdateViewServiceImpl implements VehiclePartsAddUpdateViewService {

	@Autowired
	VehiclePartsAddUpdateViewRepository vehiclePartsAUDRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void saveVehicleParts(VehicleParts vehicleParts) {
		vehiclePartsAUDRepository.saveVehicleParts(vehicleParts);
		System.out.println("Vehicle Repository to save new vehicle called");
	}

	@Override
	public void updateVehicleParts(VehicleParts vehicleParts, String regNumber) {

		vehiclePartsAUDRepository.updateVehicleParts(vehicleParts, regNumber);
		System.out.println("Vehicle Repository to update vehicle called");
	}

	public String deleteVehicleParts(String regNumber) {
		System.out.println("Vehicle Repository to delete vehicle called");
		return vehiclePartsAUDRepository.deleteVehicle(regNumber);
	}

}

package com.motors.gm.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motors.gm.model.VehicleModel;
import com.motors.gm.repository.VehicleModelAddUpdateViewDeleteRepository;
import com.motors.gm.service.VehicleModelAddUpdateViewDeleteService;

@RestController
@RequestMapping(path = "/addUpdateViewAsset")
@Validated
public class VehicleModelAddUpdateViewDeleteController {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	VehicleModelAddUpdateViewDeleteService vehicleModelAddUpdateViewService;

	// @Autowired
	// VehicleAddUpdateViewRepository vehicleAddUpdateViewRepository;

	// Save method will call service save method to add new vehicle into DB
	//Annotation Based Validation: used @Valid annotation to validate if the request body has met all the validations put on the VehicleModel class
	@PostMapping(path = "/addVehicle", produces = "application/json")
	public String save(@Valid @RequestBody VehicleModel vehicleModel) {
		vehicleModelAddUpdateViewService.saveVehicle(vehicleModel);
		return "Save Success";
	}

	// update method will call service update method to update the existing
	// vehicle in DB
	//Used Annotation Validation for the path variables passed in (@NotEmpty, @NotBlank) using class javax.validation.constraints.NotBlank and NotEmpty
	@PutMapping(path = "/updateVehicle/{regNumber}", produces = "application/json")
	public String update(@RequestBody VehicleModel vehicleModel, @PathVariable @NotEmpty @NotBlank String regNumber) {
		vehicleModelAddUpdateViewService.updateVehicle(vehicleModel, regNumber);
		return "Update Success";
	}

	// delete method will call service delete method to delete the existing
	// vehicle in DB
	//Used Annotation Validation for the path variables passed in (@NotEmpty, @NotBlank) using class javax.validation.constraints.NotBlank and NotEmpty
	@DeleteMapping(path = "/deleteVehicle/{regNumber}", produces = "application/json")
	public String deleteVehicle(@PathVariable @NotEmpty @NotBlank String regNumber) {
		return vehicleModelAddUpdateViewService.deleteVehicle(regNumber);
	}

	// findAllVehicle method will call service findAllVehicle method to findAll
	// existing vehicles in DB
	@GetMapping(path = "/findAllVehicle", produces = "application/json")
	public List<VehicleModel> findAllVehicleDetails() {
		System.out.println("Below are the all available cars: \n " + vehicleModelAddUpdateViewService.findAllVehicle());
		return vehicleModelAddUpdateViewService.findAllVehicle();
	}

	// findVehicleByRegNumber method will call service findVehicleByRegNumber
	//Used Annotation Validation for the path variables passed in (@NotEmpty, @NotBlank) using class javax.validation.constraints.NotBlank and NotEmpty
	// method to findVehicleByRegNumber in DB
	@GetMapping(path = "/findVehicleByRegNumber/{regNumber}", produces = "application/json")
	public List<VehicleModel> findByRegNumberVehicleDetails(@PathVariable @NotBlank @NotEmpty String regNumber) {
		System.out.println("Below are the all available cars: \n "
				+ vehicleModelAddUpdateViewService.findVehicleByRegNumber(regNumber));
		return vehicleModelAddUpdateViewService.findVehicleByRegNumber(regNumber);
	}

	// findVehicleByFeatures method will call service findVehicleByFeatures
	// method to findVehicleByFeatures provided by user in DB
	@GetMapping(path = "/findVehicleByFeatures", produces = "application/json")
	public List<VehicleModel> findVehicleByFeaturesVehicleDetails(@RequestBody VehicleModel vehicleModel) {
		System.out.println("Below are the all available cars: \n "
				+ vehicleModelAddUpdateViewService.findVehicleByFeaturesVehicleDetails(vehicleModel));
		return vehicleModelAddUpdateViewService.findVehicleByFeaturesVehicleDetails(vehicleModel);
	}
}

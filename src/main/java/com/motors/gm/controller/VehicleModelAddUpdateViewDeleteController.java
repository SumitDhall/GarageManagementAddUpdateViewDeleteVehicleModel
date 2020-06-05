package com.motors.gm.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.motors.gm.exception.ActorNotFoundException;
import com.motors.gm.model.VehicleModel;
import com.motors.gm.service.VehicleModelAddUpdateViewDeleteService;

@RestController
@RequestMapping(path = "/addUpdateViewAsset")
@Validated
public class VehicleModelAddUpdateViewDeleteController {

	private static final Logger LOGGER = LogManager.getLogger(VehicleModelAddUpdateViewDeleteController.class.getName());
	List<VehicleModel> vehicleModelResult = null;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	VehicleModelAddUpdateViewDeleteService vehicleModelAddUpdateViewService;

	// @Autowired
	// VehicleAddUpdateViewRepository vehicleAddUpdateViewRepository;

	// Save method will call service save method to add new vehicle into DB
	//Annotation Based Validation: used @Valid annotation to validate if the request body has met all the validations put on the VehicleModel class
	@PostMapping(path = "/addVehicle", produces = "application/json")
	public ResponseEntity<VehicleModel> save(@Valid @RequestBody VehicleModel vehicleModel) {
		LOGGER.info("Garage Management Add Vehicle Model Service");
		 String result = vehicleModelAddUpdateViewService.saveVehicle(vehicleModel);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("saveVehicle", "saved");
		if(result.equalsIgnoreCase("Saved")){
			return new ResponseEntity<>(HttpStatus.CREATED); //"Save Success";
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	// update method will call service update method to update the existing
	// vehicle in DB
	//Used Annotation Validation for the path variables passed in (@NotEmpty, @NotBlank) using class javax.validation.constraints.NotBlank and NotEmpty
	@PutMapping(path = "/updateVehicle/{regNumber}", produces = "application/json")
	public String update(@RequestBody VehicleModel vehicleModel, @PathVariable @NotEmpty @NotBlank String regNumber) {
		LOGGER.info("Garage Management Update Vehicle Model Service");
		
		// TO_DO Send the response entity body - 27/05/2020
		//Send Return message format - Code/message using HTTP - Apply HTTP code where default codes are present.
		//Custom Error CE_1289
		
		try{vehicleModelAddUpdateViewService.updateVehicle(vehicleModel, regNumber);
		}catch (ActorNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle Not Found", ex);
        }
		return "Update Success";
	}

	// delete method will call service delete method to delete the existing
	// vehicle in DB
	//Used Annotation Validation for the path variables passed in (@NotEmpty, @NotBlank) using class javax.validation.constraints.NotBlank and NotEmpty
	@DeleteMapping(path = "/deleteVehicle/{regNumber}", produces = "application/json")
	public ResponseEntity<String> deleteVehicle(@PathVariable @NotEmpty @NotBlank String regNumber) {
		LOGGER.info("Garage Management Delete Vehicle Model Service");
		try{ vehicleModelAddUpdateViewService.deleteVehicle(regNumber);
		}catch (ActorNotFoundException ex) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found", ex);
	    }
		//return new ResponseEntity<VehicleModel>("", HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully!!");
	}

	// findAllVehicle method will call service findAllVehicle method to findAll
	// existing vehicles in DB
	@GetMapping(path = "/findAllVehicle", produces = "application/json")
	public List<VehicleModel> findAllVehicleDetails() {
		LOGGER.info("Garage Management View All Vehicle Model Service");
		LOGGER.debug("Below are the all available cars: \n " + vehicleModelAddUpdateViewService.findAllVehicle());
		return vehicleModelAddUpdateViewService.findAllVehicle();
	}

	// findVehicleByRegNumber method will call service findVehicleByRegNumber
	//Used Annotation Validation for the path variables passed in (@NotEmpty, @NotBlank) using class javax.validation.constraints.NotBlank and NotEmpty
	// method to findVehicleByRegNumber in DB
	@GetMapping(path = "/findVehicleByRegNumber/{regNumber}", produces = "application/json")
	public ResponseEntity<List<VehicleModel>> findByRegNumberVehicleDetails(@PathVariable @NotBlank @NotEmpty String regNumber) {
		LOGGER.info("Garage Management View Vehicle Model with Registration Number, Vehicle Model Service");
//		LOGGER.debug("Below are the all available cars: \n "
//				+ vehicleModelAddUpdateViewService.findVehicleByRegNumber(regNumber));
		
		try{ vehicleModelResult = vehicleModelAddUpdateViewService.findVehicleByRegNumber(regNumber);
	}catch (ActorNotFoundException ex) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found", ex);
    }
		return new ResponseEntity<>(vehicleModelResult, HttpStatus.OK );
	}

	// findVehicleByFeatures method will call service findVehicleByFeatures
	// method to findVehicleByFeatures provided by user in DB
	@GetMapping(path = "/findVehicleByFeatures", produces = "application/json")
	public List<VehicleModel> findVehicleByFeaturesVehicleDetails(@RequestBody VehicleModel vehicleModel) {
		LOGGER.info("Garage Management View Vehicle Model with different features, Vehicle Model Service");
//		LOGGER.debug("Below are the all available cars: \n "
//				+ vehicleModelAddUpdateViewService.findVehicleByFeaturesVehicleDetails(vehicleModel));
		return vehicleModelAddUpdateViewService.findVehicleByFeaturesVehicleDetails(vehicleModel);
	}
}

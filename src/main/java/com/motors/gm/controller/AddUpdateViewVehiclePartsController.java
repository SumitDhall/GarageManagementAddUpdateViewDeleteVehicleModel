//package com.motors.gm.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.motors.gm.model.VehicleModel;
//import com.motors.gm.model.VehicleParts;
//import com.motors.gm.service.VehicleAudService;
//import com.motors.gm.service.VehiclePartsAUDService;
//
//@RestController
//@RequestMapping(path = "/audAsset")
//public class AUDVehiclePartsController {
//
//	@Autowired
//	private MongoTemplate mongoTemplate;
//
//	@Autowired
//	VehicleAudService VehicleAudService;
//
//	@Autowired
//	VehiclePartsAUDService vehiclePartsAUDService;
//
//	@PostMapping(path = "/addVehicleParts", produces = "application/json")
//	public String save(@RequestBody VehicleParts vehicleParts) {
//		vehiclePartsAUDService.saveVehicleParts(vehicleParts);
//		return "Save Parts Success";
//	}
//
//	
//	  @PutMapping(path="/updateVehicle/{regNumber}", produces ="application/json") 
//	  public String update(@RequestBody VehicleModel
//	  vehicleModel, @PathVariable String regNumber) {
//	  VehicleAudService.updateVehicle(vehicleModel, regNumber); return
//	  "Update Success"; }
//	  
//	  @DeleteMapping(path="/deleteVehicle/{regNumber}", produces =
//	  "application/json") public String deleteVehicle(@PathVariable String
//	  regNumber) { return VehicleAudService.deleteVehicle(regNumber); }
//	 
//}

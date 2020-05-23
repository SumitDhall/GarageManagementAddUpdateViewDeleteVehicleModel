
package com.motors.gm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.motors.gm.model.VehicleParts;

@Repository
@EnableMongoRepositories
public class VehiclePartsAddUpdateViewRepositoryImpl implements VehiclePartsAddUpdateViewRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String saveVehicleParts(VehicleParts vehicleParts) {
		System.out.println("saveVehiclePartsApacheKafka method call");
		return saveVehiclePartsApacheKafka(vehicleParts);
		// mongoTemplate.insert(vehicleModel);
		// return "Vehicle Saved Successfully";
	}

	
	public String saveVehiclePartsApacheKafka(VehicleParts vehicleParts) {
		mongoTemplate.insert(vehicleParts);
		System.out.println("Vehicle Parts is saved in DB");
		return "Vehicle Parts Saved Successfully";
	}

	
	  public VehicleParts updateVehicleParts(VehicleParts vehicleParts, String
	  regNumber){ //Query updateQuery = new Query();
	  //updateQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
	 // Update update = new Update(); //update.set("make",vehicleModel.getMake()); //update.set("model" ,vehicleModel.getModel());
	  return updateVehiclePartsApacheKafka(vehicleParts, regNumber); //
	  //mongoTemplate.findAndModify(updateQuery, update, VehicleModel.class);
	  
	  }
	  
	  public VehicleParts updateVehiclePartsApacheKafka(VehicleParts vehicleParts, String regNumber){ 
	  Query updateQuery = new Query();
	  updateQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
	  Update update = new Update(); 
	  update.set("regNumber" ,vehicleParts.getRegNumber());
	  
	  return vehicleParts;//mongoTemplate.findAndModify(updateQuery, update, vehicleParts.class);
	  
	  }
	  
	  public String deleteVehicle(String regNumber){ //Query deleteQuery = new Query();
	  //deleteQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
	  //mongoTemplate.remove(deleteQuery, VehicleModel.class); return
	  deleteVehicleApacheKafka(regNumber); //
	  return "Vehicle Deleted successfully from DB";
	  
	  }
	  
	  public String deleteVehicleApacheKafka(String regNumber){ Query
	  deleteQuery = new Query();
	  deleteQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
	  mongoTemplate.remove(deleteQuery, VehicleParts.class); 
	  return "Vehicle Deleted successfully from DB";
	  
	  }
	 
}

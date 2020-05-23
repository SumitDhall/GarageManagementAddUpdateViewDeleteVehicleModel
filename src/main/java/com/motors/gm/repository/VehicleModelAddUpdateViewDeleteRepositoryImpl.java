package com.motors.gm.repository;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.motors.gm.model.VehicleModel;

@Repository
@EnableMongoRepositories
public class VehicleModelAddUpdateViewDeleteRepositoryImpl implements VehicleModelAddUpdateViewDeleteRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String saveVehicle(VehicleModel vehicleModel) {
		System.out.println("saveVehicleApacheKafka method call");
		return saveVehicleApacheKafka(vehicleModel);
		// mongoTemplate.insert(vehicleModel);
		// return "Vehicle Saved Successfully";
	}

	public String saveVehicleApacheKafka(VehicleModel vehicleModel) {
		mongoTemplate.insert(vehicleModel);
		System.out.println("Vehicle Record is saved in DB");
		return "Vehicle Saved Successfully";
	}

	public VehicleModel updateVehicle(VehicleModel vehicleModel, String regNumber) {
		// Query updateQuery = new Query();
		// updateQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
		// Update update = new Update();
		// update.set("make" ,vehicleModel.getMake());
		// update.set("model" ,vehicleModel.getModel());
		return updateVehicleApacheKafka(vehicleModel, regNumber);
		// mongoTemplate.findAndModify(updateQuery, update, VehicleModel.class);

	}

	public VehicleModel updateVehicleApacheKafka(VehicleModel vehicleModel, String regNumber) {
		Query updateQuery = new Query();
		updateQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
		Update update = new Update();
		if (null != vehicleModel.getMake() && "" != vehicleModel.getMake()) {
			update.set("make", vehicleModel.getMake());
		}
		if (null != vehicleModel.getModel() && "" != vehicleModel.getModel()) {
			update.set("model", vehicleModel.getModel());
		}
		if (null != vehicleModel.getModelVariant() && "" != vehicleModel.getModelVariant()) {
			update.set("modelVariant", vehicleModel.getModelVariant());
		}
		if (null != vehicleModel.getFuelType() && "" != vehicleModel.getFuelType()) {
			update.set("fuelType", vehicleModel.getFuelType());
		}
		if (null != vehicleModel.getNumberOfDoors()) {
			update.set("numberOfDoors", vehicleModel.getNumberOfDoors());
		}
		if (null != vehicleModel.getEngineSize()) {
			update.set("engineSize", vehicleModel.getEngineSize());
		}
		if (null != vehicleModel.getMilage()) {
			update.set("milage", vehicleModel.getMilage());
		}
		if (null != vehicleModel.getAnnualTax()) {
			update.set("annualTax", vehicleModel.getAnnualTax());
		}
		if (null != vehicleModel.getCo2Emission()) {
			update.set("co2Emission", vehicleModel.getCo2Emission());
		}
		if (null != vehicleModel.getColour() && "" != vehicleModel.getColour()) {
			update.set("colour", vehicleModel.getColour());
		}
		if (null != vehicleModel.getBodyType() && "" != vehicleModel.getBodyType()) {
			update.set("bodyType", vehicleModel.getBodyType());
		}
		if (null != vehicleModel.getFuelConsumption()) {
			update.set("fuelConsumption", vehicleModel.getFuelConsumption());
		}
		if (null != vehicleModel.getInsuranceGroup() && "" != vehicleModel.getInsuranceGroup()) {
			update.set("insuranceGroup", vehicleModel.getInsuranceGroup());
		}
		if (null != vehicleModel.getBuyPrice()) {
			update.set("buyPrice", vehicleModel.getBuyPrice());
		}
		if (null != vehicleModel.getSalePrice()) {
			update.set("salePrice", vehicleModel.getSalePrice());
		}
		if (null != vehicleModel.getGearBox() && "" != vehicleModel.getGearBox()) {
			update.set("gearBox", vehicleModel.getGearBox());
		}

		return mongoTemplate.findAndModify(updateQuery, update, VehicleModel.class);

	}

	@Override
	public List<VehicleModel> findAllVehicle() {

		System.out.println("Retrieving all vehicles available");
		return findAllVehicleApacheKafka();
	}

	public List<VehicleModel> findAllVehicleApacheKafka() {

		System.out.println("Retrieving all vehicles available");
		return mongoTemplate.findAll(VehicleModel.class);
	}

	@Override
	public List<VehicleModel> findVehicleByRegNumber(String regNumber) {

		System.out.println("Retrieving RegNumber vehicles available");
		return findVehicleByRegNumberApacheKafka(regNumber);
	}

	public List<VehicleModel> findVehicleByRegNumberApacheKafka(String regNumber) {

		System.out.println("Retrieving all vehicles available");
		Query query = new Query();
		query.addCriteria(Criteria.where("regNumber").is(regNumber));
		return mongoTemplate.find(query, VehicleModel.class);
	}

	// @Override
	// public List<VehicleModel>
	// findVehicleByFeaturesVehicleDetails(VehicleModel vehicleModel) {
	// // TODO Auto-generated method stub
	// // TODO - Implement this method
	// return null;
	// }

	// TODO - Implement this method

	@Override
	public List<VehicleModel> findVehicleByFeaturesVehicleDetails(VehicleModel vehicleModel) {

		System.out.println("Retrieving vehicles with features available");
		return findVehicleByFeaturesVehicleDetailsApacheKafka(vehicleModel);
	}

	public List<VehicleModel> findVehicleByFeaturesVehicleDetailsApacheKafka(VehicleModel vehicleModel) {

		System.out.println("Retrieving all vehicles available");
		Query query = new Query();
		List<VehicleModel> resultset = null;
		Criteria criteria = new Criteria();

		if (vehicleModel.getRegNumber() != null) {
			criteria.and("regNumber").is(vehicleModel.getRegNumber());
		}
		if (vehicleModel.getMake() != null) {
			criteria.and("make").is(vehicleModel.getMake());
		}
		if (vehicleModel.getModel() != null) {
			criteria.and("model").is(vehicleModel.getModel());
		}
		if (vehicleModel.getModelVariant() != null) {
			criteria.and("modelVariant").is(vehicleModel.getModelVariant());
		}
		if (vehicleModel.getFuelType() != null) {
			criteria.and("fuelType").is(vehicleModel.getFuelType());
		}
		if (vehicleModel.getNumberOfDoors() != null) {
			criteria.and("numberOfDoors").is(vehicleModel.getNumberOfDoors());
		}
		if (vehicleModel.getEngineSize() != null) {
			criteria.and("engineSize").is(vehicleModel.getEngineSize());
		}
		if (vehicleModel.getMilage() != null) {
			criteria.and("milage").is(vehicleModel.getMilage());
		}
		if (vehicleModel.getAnnualTax() != null) {
			criteria.and("annualTax").is(vehicleModel.getAnnualTax());
		}
		if (vehicleModel.getCo2Emission() != null) {
			criteria.and("co2Emission").is(vehicleModel.getCo2Emission());
		}
		if (vehicleModel.getColour() != null) {
			criteria.and("colour").is(vehicleModel.getColour());
		}
		if (vehicleModel.getBodyType() != null) {
			criteria.and("bodyType").is(vehicleModel.getBodyType());
		}
		if (vehicleModel.getFuelConsumption() != null) {
			criteria.and("fuelConsumption").is(vehicleModel.getFuelConsumption());
		}
		if (vehicleModel.getInsuranceGroup() != null) {
			criteria.and("insuranceGroup").is(vehicleModel.getInsuranceGroup());
		}
		if (vehicleModel.getBuyPrice() != null) {
			criteria.and("buyPrice").is(vehicleModel.getBuyPrice());
		}
		if (vehicleModel.getSalePrice() != null) {
			criteria.and("salePrice").is(vehicleModel.getSalePrice());
		}
		if (vehicleModel.getGearBox() != null) {
			criteria.and("gearBox").is(vehicleModel.getGearBox());
		}

		// And query to find the cars with provided features
		// query.addCriteria(
		// criteria.andOperator(
		// //if(!vehicleModel.getRegNumber().isEmpty()){
		// criteria.where("regNumber").is(vehicleModel.getRegNumber()),
		// //}
		// criteria.where("make").is(vehicleModel.getMake()),
		// criteria.where("model").is(vehicleModel.getModel()),
		// criteria.where("modelVariant").is(vehicleModel.getModelVariant()),
		// criteria.where("fuelType").is(vehicleModel.getFuelType()),
		// criteria.where("numberOfDoors").is(vehicleModel.getNumberOfDoors()),
		// criteria.where("engineSize").is(vehicleModel.getEngineSize()),
		// criteria.where("milage").is(vehicleModel.getMilage()),
		// criteria.where("annualTax").is(vehicleModel.getAnnualTax()),
		// criteria.where("co2Emission").is(vehicleModel.getCo2Emission()),
		// criteria.where("colour").is(vehicleModel.getColour()),
		// criteria.where("bodyType").is(vehicleModel.getBodyType()),
		// criteria.where("fuelConsumption").is(vehicleModel.getFuelConsumption()),
		// criteria.where("insuranceGroup").is(vehicleModel.getInsuranceGroup()),
		// criteria.where("buyPrice").is(vehicleModel.getBuyPrice()),
		// criteria.where("salePrice").is(vehicleModel.getSalePrice()),
		// criteria.where("gearBox").is(vehicleModel.getGearBox())
		//
		// )
		// );

		if (criteria != null) {
			query.addCriteria(criteria);
			resultset = mongoTemplate.find(query, VehicleModel.class);
		}
		return resultset;

	}

	public String deleteVehicle(String regNumber) {
		// Query deleteQuery = new Query();
		// deleteQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
		// mongoTemplate.remove(deleteQuery, VehicleModel.class);
		return deleteVehicleApacheKafka(regNumber);
		// return "Vehicle Deleted successfully from DB";

	}

	public String deleteVehicleApacheKafka(String regNumber) {
		Query deleteQuery = new Query();
		deleteQuery.addCriteria(Criteria.where("regNumber").is(regNumber));
		mongoTemplate.remove(deleteQuery, VehicleModel.class);
		return "Vehicle Deleted successfully from DB";

	}
}

package com.motors.gm.garageManagementAUVD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"com.motors.gm"})
@EntityScan("com.motors.gm")
@EnableMongoRepositories("com.motors.gm")
public class GarageManagementAddUpdateViewDeleteApplication extends SpringBootServletInitializer{

	
	public static void main(String[] args) {
		SpringApplication.run(GarageManagementAddUpdateViewDeleteApplication.class, args);
		System.out.println("Garage Management Add Update Delete Rest API");
		
		/*TestModel testModel = new TestModel();
		testModel.setfName("Sum");
		testModel.setlName("Dhall");
		
		//VehicleAUDServiceImpl vehicleAUDServiceImpl = new VehicleAUDServiceImpl();
		@Autowired
		VehicleAUDRepository vehicleAUDRepository;// = new VehicleAUDRepositoryImpl();
		vehicleAUDRepository.saveVehicle(testModel);*/
	}

}

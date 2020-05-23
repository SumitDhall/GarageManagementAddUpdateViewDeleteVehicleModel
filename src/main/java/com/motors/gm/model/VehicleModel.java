package com.motors.gm.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.mongodb.lang.NonNull;
import com.motors.gm.garageManagementAUVD.GarageManagementAddUpdateViewDeleteApplication;

@Document("vehicleModel")
public class VehicleModel {
	
	private static final Logger LOGGER = LogManager.getLogger(VehicleModel.class.getName());
	
	@Id
	@NotEmpty(message="Please provide the Car Registration Number")
	@NotNull
	@NotBlank
	private String regNumber;
	
	private String make;
	private String model;
	private String modelVariant;
	private String fuelType;
	private Integer numberOfDoors;
	private Integer engineSize;
	private Double milage;
	private Integer annualTax;
	private Double co2Emission;
	private String colour;
	private String bodyType;
	private String gearBox;
	private Float fuelConsumption;
	private String insuranceGroup;
	private Double buyPrice;
	private Double salePrice;
	
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModelVariant() {
		return modelVariant;
	}
	public void setModelVariant(String modelVariant) {
		this.modelVariant = modelVariant;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public Integer getNumberOfDoors() {
		return numberOfDoors;
	}
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	public Integer getEngineSize() {
		return engineSize;
	}
	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}
	public Double getMilage() {
		return milage;
	}
	public void setMilage(double milage) {
		this.milage = milage;
	}
	public Integer getAnnualTax() {
		return annualTax;
	}
	public void setAnnualTax(int annualTax) {
		this.annualTax = annualTax;
	}
	public Double getCo2Emission() {
		return co2Emission;
	}
	public void setCo2Emission(double co2Emission) {
		this.co2Emission = co2Emission;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	
	public String getGearBox() {
		return gearBox;
	}
	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}
	public Float getFuelConsumption() {
		return fuelConsumption;
	}
	public void setFuelConsumption(float fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	public String getInsuranceGroup() {
		return insuranceGroup;
	}
	public void setInsuranceGroup(String insuranceGroup) {
		this.insuranceGroup = insuranceGroup;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	
}

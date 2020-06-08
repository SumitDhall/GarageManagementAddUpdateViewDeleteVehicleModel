package com.motors.gm.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class VehicleModelBase {

	@Id
	@NotEmpty(message = "Please provide the Car Registration Number")
	@NotNull
	@NotBlank
	private UUID id;

	private RegNumber regNumber;
	private String make;
	private String model;
	private String modelVariant;
	private String fuelType;
	private String numberOfDoors;
	private String engineSize;
	private Mileage mileage;
	private String co2Emission;
	private Colour colour;
	private String bodyType;
	private String gearBox;
	private String fuelConsumption;
	private InsuranceGroup insuranceGroup;
	private String chasisNumber;
	private Price price;
	private Year year;
	private String acceleration;
	private Tax tax;
	private String drivetrain;
	private String ulez;
	private String cat;
	private String seatCapacity;
	private String modifiedVehicle;
	private String vehicleClass;

	public RegNumber getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(RegNumber regNumber) {
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

	public String getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(String numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public String getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	public Mileage getMileage() {
		return mileage;
	}

	public void setMileage(Mileage mileage) {
		this.mileage = mileage;
	}

	public String getCo2Emission() {
		return co2Emission;
	}

	public void setCo2Emission(String co2Emission) {
		this.co2Emission = co2Emission;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
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

	public String getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(String fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public InsuranceGroup getInsuranceGroup() {
		return insuranceGroup;
	}

	public void setInsuranceGroup(InsuranceGroup insuranceGroup) {
		this.insuranceGroup = insuranceGroup;
	}

	public String getChasisNumber() {
		return chasisNumber;
	}

	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public String getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(String acceleration) {
		this.acceleration = acceleration;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public String getDrivetrain() {
		return drivetrain;
	}

	public void setDrivetrain(String drivetrain) {
		this.drivetrain = drivetrain;
	}

	public String getUlez() {
		return ulez;
	}

	public void setUlez(String ulez) {
		this.ulez = ulez;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(String seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public String getModifiedVehicle() {
		return modifiedVehicle;
	}

	public void setModifiedVehicle(String modifiedVehicle) {
		this.modifiedVehicle = modifiedVehicle;
	}

	public String getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

}
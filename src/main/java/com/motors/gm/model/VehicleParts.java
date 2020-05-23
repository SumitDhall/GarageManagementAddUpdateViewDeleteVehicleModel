package com.motors.gm.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("vehicleParts")
public class VehicleParts {

	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	@Id
	private String regNumber;
		
	private ArrayList<String> engineParts;
	private ArrayList<String> bodyParts;
	private ArrayList<String> interiorParts;
	private ArrayList<String> luxuryParts;
	
	public ArrayList<String> getEngineParts() {
		return engineParts;
	}
	public void setEngineParts(ArrayList<String> engineParts) {
		this.engineParts = engineParts;
	}
	public ArrayList<String> getBodyParts() {
		return bodyParts;
	}
	public void setBodyParts(ArrayList<String> bodyParts) {
		this.bodyParts = bodyParts;
	}
	public ArrayList<String> getInteriorParts() {
		return interiorParts;
	}
	public void setInteriorParts(ArrayList<String> interiorParts) {
		this.interiorParts = interiorParts;
	}
	public ArrayList<String> getLuxuryParts() {
		return luxuryParts;
	}
	public void setLuxuryParts(ArrayList<String> luxuryParts) {
		this.luxuryParts = luxuryParts;
	}
}

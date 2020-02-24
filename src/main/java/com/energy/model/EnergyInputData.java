package com.energy.model;

import org.springframework.stereotype.Component;

@Component
public class EnergyInputData {

	private int counterId;
	private double consumptionAmount;
	private String villageName;	

	public int getCounterId() {
		return counterId;
	}
	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}
	public double getConsumptionAmount() {
		return consumptionAmount;
	}
	public void setConsumptionAmount(double consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	
	
	
}

package com.energy.entity;
import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity(name = "ENERGY_DATA")
@Table(name="ENERGY_DATA")
public class EnergyDataEntity {
	
     @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;

	 @Column(name = "village_name")
	 private String villageName;
	 
	 @Column(name = "consumption_amount")
	 private Double consumptionAmount;
	 
	 @Column(name="counter_id")
	 private Integer counterId;
	 
	 @Column(name="last_Updated_Date")
	 private Date lastUpdatedDate = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Double getConsumptionAmount() {
		return consumptionAmount;
	}

	public void setConsumptionAmount(Double consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}

	public Integer getCounterId() {
		return counterId;
	}

	public void setCounterId(Integer counterId) {
		this.counterId = counterId;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}


	 
}

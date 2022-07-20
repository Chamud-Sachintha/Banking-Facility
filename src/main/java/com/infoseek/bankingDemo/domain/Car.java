package com.infoseek.bankingDemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long carId;
	private String engineNo;
	private String chasieNo;
	private String status;
	private String yearOfMake;
	
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getChasieNo() {
		return chasieNo;
	}
	public void setChasieNo(String chasieNo) {
		this.chasieNo = chasieNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getYearOfMake() {
		return yearOfMake;
	}
	public void setYearOfMake(String yearOfMake) {
		this.yearOfMake = yearOfMake;
	}
}

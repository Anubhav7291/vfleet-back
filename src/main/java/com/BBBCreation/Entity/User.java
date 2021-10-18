package com.BBBCreation.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	private String vehicleNumber;
	private String chassisNo;
	private String modelNo;
	private String engineNo;
	private String owner;
	private LocalDate insuranceDate;
	private LocalDate validUpto;
	private String vehicleMake;
	private String vehicleType;
	private String manufacturing;
	private String entryPass;
	private String companyName;
	private String policyNumber;
	private LocalDate pollutionDateFrom;
	private LocalDate pollutionDateTo;
	private LocalDate fitnessDateFrom;
	private LocalDate fitnessDateTo;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public LocalDate getPollutionDateFrom() {
		return pollutionDateFrom;
	}
	public void setPollutionDateFrom(LocalDate pollutionDateFrom) {
		this.pollutionDateFrom = pollutionDateFrom;
	}
	public LocalDate getPollutionDateTo() {
		return pollutionDateTo;
	}
	public void setPollutionDateTo(LocalDate pollutionDateTo) {
		this.pollutionDateTo = pollutionDateTo;
	}
	public LocalDate getFitnessDateFrom() {
		return fitnessDateFrom;
	}
	public void setFitnessDateFrom(LocalDate fitnessDateFrom) {
		this.fitnessDateFrom = fitnessDateFrom;
	}
	public LocalDate getFitnessDateTo() {
		return fitnessDateTo;
	}
	public void setFitnessDateTo(LocalDate fitnessDateTo) {
		this.fitnessDateTo = fitnessDateTo;
	}
	public LocalDate getValidUpto() {
		return validUpto;
	}
	public void setValidUpto(LocalDate validUpto) {
		this.validUpto = validUpto;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public LocalDate getInsuranceDate() {
		return insuranceDate;
	}
	public void setInsuranceDate(LocalDate insuranceDate) {
		this.insuranceDate = insuranceDate;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getManufacturing() {
		return manufacturing;
	}
	public void setManufacturing(String manufacturing) {
		this.manufacturing = manufacturing;
	}
	public String getEntryPass() {
		return entryPass;
	}
	public void setEntryPass(String entryPass) {
		this.entryPass = entryPass;
	}
	
	
}

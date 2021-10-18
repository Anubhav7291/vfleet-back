package com.BBBCreation.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="drivers")
public class Driver {
	
	
	private String driverName;
	@Id
	private String licenseNumber;
	private String mobileNumber;
	private String eMobileNumber;
	private String aadharNumber;
	private String permitType;
	private LocalDate licenseStart;
	private LocalDate licenseExpiry;
	private String address;
	private byte[] picByte;
	private LocalDate joiningDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="driverId")
	private List<User> vehicles;
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public LocalDate getLicenseExpiry() {
		return licenseExpiry;
	}
	public void setLicenseExpiry(LocalDate licenseExpiry) {
		this.licenseExpiry = licenseExpiry;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public List<User> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<User> vehicles) {
		this.vehicles = vehicles;
	}
	public String geteMobileNumber() {
		return eMobileNumber;
	}
	public void seteMobileNumber(String eMobileNumber) {
		this.eMobileNumber = eMobileNumber;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPermitType() {
		return permitType;
	}
	public void setPermitType(String permitType) {
		this.permitType = permitType;
	}
	public LocalDate getLicenseStart() {
		return licenseStart;
	}
	public void setLicenseStart(LocalDate licenseStart) {
		this.licenseStart = licenseStart;
	}
	public byte[] getPicByte() {
		return picByte;
	}
	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	
	
}

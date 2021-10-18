package com.BBBCreation.DTO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;



public class DriverDTO {
	private String driverName;
	private String licenseNumber;
	private String mobileNumber;
	private String eMobileNumber;
	private String aadharNumber;
	private String permitType;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate licenseStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate licenseExpiry;
	private String address;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;
	private byte[]  picByte;
	private String setPicToString;
	private List<UserDTO> vehicles;
	
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
	public List<UserDTO> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<UserDTO> vehicles) {
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
	public LocalDate getLicenseStart() {
		return licenseStart;
	}
	public void setLicenseStart(LocalDate licenseStart) {
		this.licenseStart = licenseStart;
	}
	public String getPermitType() {
		return permitType;
	}
	public void setPermitType(String permitType) {
		this.permitType = permitType;
	}
	public byte[]  getPicByte() {
		return picByte;
	}
	public void setPicByte(byte[]  picByte) {
		this.picByte = picByte;
	}
	public String getSetPicToString() {
		return setPicToString;
	}
	public void setSetPicToString(String setPicToString) {
		this.setPicToString = setPicToString;
	}
	
}

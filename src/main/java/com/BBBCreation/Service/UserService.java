package com.BBBCreation.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.BBBCreation.DTO.DriverDTO;
import com.BBBCreation.DTO.UserDTO;
import com.BBBCreation.Utility.VehicleMangementException;

public interface UserService {
	
	public List<UserDTO> getAlldetails() throws VehicleMangementException;
	public UserDTO getDetailsbyId(String vehicleNumber) throws VehicleMangementException;
	public String addDetail(UserDTO userdto) throws VehicleMangementException;
	public String updateDetails(String vehicleid,UserDTO userdto) throws VehicleMangementException;
	public void deleteDetail(String vehiclenumber) throws VehicleMangementException;
	public List<UserDTO> alerts() throws VehicleMangementException;
	
	public String addDriver(DriverDTO driveDTO) throws VehicleMangementException;
	public String issueVehicleToExistingDriver(String driverId, UserDTO userdto) throws VehicleMangementException;
	public DriverDTO getDriverDetails(String driveId) throws VehicleMangementException, UnsupportedEncodingException;
	public List<DriverDTO> getAllDriverDetails() throws VehicleMangementException;
	
	void deleteDriver(String driverId) throws VehicleMangementException;
	List<DriverDTO> alertsDriver() throws VehicleMangementException;
	
	String addDriver(DriverDTO driveDTO,String vehicleNumber)
			throws VehicleMangementException, IOException;
	String editDriver(String driverId, DriverDTO driveDTO, String vehicleNumber)
			throws VehicleMangementException, IOException;
	String addDetailWithDriver(UserDTO userdto, String driverId) throws VehicleMangementException;
}

package com.BBBCreation.Service;

import java.time.LocalDate;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.BBBCreation.DTO.DriverDTO;
import com.BBBCreation.DTO.UserDTO;
import com.BBBCreation.Entity.Driver;
import com.BBBCreation.Entity.User;
import com.BBBCreation.Repository.DriverRepository;
import com.BBBCreation.Repository.UserRepository;
import com.BBBCreation.Utility.VehicleMangementException;
import java.time.temporal.ChronoUnit;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DriverRepository driverrepository;
	
//	Adding user vehicle data
	@Override
	public String addDetail(UserDTO userdto) throws VehicleMangementException{
		User user=new User();
		Optional<User> opt=userRepository.findById(userdto.getVehicleNumber());
		if(opt.isPresent()) {
			throw new VehicleMangementException("Data with this Vehicle number already Exist");
		}
		user.setVehicleNumber(userdto.getVehicleNumber());
		user.setChassisNo(userdto.getChassisNo());
		user.setModelNo(userdto.getModelNo());
		user.setEngineNo(userdto.getEngineNo());
		user.setInsuranceDate(userdto.getInsuranceDate());
		user.setOwner(userdto.getOwner());
		user.setValidUpto(userdto.getValidUpto());
		userRepository.save(user);
		return user.getVehicleNumber();
	}
	
//	Adding vehicle with driver
	
	@Override
	public String addDetailWithDriver(UserDTO userdto,String driverId) throws VehicleMangementException{
		User user=new User();
		Optional<User> opt=userRepository.findById(userdto.getVehicleNumber());
		if(opt.isPresent()) {
			throw new VehicleMangementException("Data with this Vehicle number already Exist");
		}
		user.setVehicleNumber(userdto.getVehicleNumber());
		user.setChassisNo(userdto.getChassisNo());
		user.setModelNo(userdto.getModelNo());
		user.setEngineNo(userdto.getEngineNo());
		user.setInsuranceDate(userdto.getInsuranceDate());
		user.setOwner(userdto.getOwner());
		user.setValidUpto(userdto.getValidUpto());
		user.setEntryPass(userdto.getEntryPass());
		user.setVehicleMake(userdto.getVehicleMake());
		user.setVehicleType(userdto.getVehicleType());
		user.setManufacturing(userdto.getManufacturing());
		user.setFitnessDateFrom(userdto.getFitnessDateFrom());
		user.setFitnessDateTo(userdto.getFitnessDateTo());
		user.setPollutionDateTo(userdto.getPollutionDateTo());
		user.setPollutionDateFrom(userdto.getPollutionDateFrom());
		user.setCompanyName(userdto.getCompanyName());
		user.setPolicyNumber(userdto.getPolicyNumber());
		List<User> list=new ArrayList<>();
		list.add(user);
		
		Optional<Driver> opt1=driverrepository.findById(driverId);
		Driver driveDTO=opt1.orElseThrow(()->new VehicleMangementException("No data with given Vehicle Number"));
		
		Driver driver=new Driver();
		driver.setAddress(driveDTO.getAddress());
		driver.setDriverName(driveDTO.getDriverName());
		driver.setLicenseExpiry(driveDTO.getLicenseExpiry());
		driver.setLicenseNumber(driveDTO.getLicenseNumber());
		driver.setMobileNumber(driveDTO.getMobileNumber());
		driver.setJoiningDate(driveDTO.getJoiningDate());
		driver.setAadharNumber(driveDTO.getAadharNumber());
		driver.seteMobileNumber(driveDTO.geteMobileNumber());
		driver.setPermitType(driveDTO.getPermitType());
		driver.setLicenseStart(driveDTO.getLicenseStart());
		driver.setPicByte(driveDTO.getPicByte());
		driver.setVehicles(list);
		userRepository.save(user);
		driverrepository.save(driver);
		return user.getVehicleNumber();
	}

//	Getting all Vehicle data 
	@Override
	public List<UserDTO> getAlldetails() throws VehicleMangementException{
		Iterable<User> users=userRepository.findAll();
		List<UserDTO> userdtos=new ArrayList<>();
		users.forEach(user->{
			UserDTO u=new UserDTO();
			u.setVehicleNumber(user.getVehicleNumber());
			u.setChassisNo(user.getChassisNo());
			u.setModelNo(user.getModelNo());
			u.setEngineNo(user.getEngineNo());
			u.setOwner(user.getOwner());
			u.setInsuranceDate(user.getInsuranceDate());	
			u.setValidUpto(user.getValidUpto());
		userdtos.add(u);
		});
		if(userdtos.isEmpty()) {
			throw new VehicleMangementException("No Data Found");
		}
		return userdtos;
		
	}
//Getting data with Vehicle ID
	@Override
	public UserDTO getDetailsbyId(String vehicleNumber) throws VehicleMangementException {
		// TODO Auto-generated method stub
		Optional<User> opt=userRepository.findById(vehicleNumber);
		User user=opt.orElseThrow(()->new VehicleMangementException("No data with given Vehicle Number"));
		UserDTO u=new UserDTO();
		u.setVehicleNumber(user.getVehicleNumber());
		u.setChassisNo(user.getChassisNo());
		u.setModelNo(user.getModelNo());
		u.setEngineNo(user.getEngineNo());
		u.setOwner(user.getOwner());
		u.setInsuranceDate(user.getInsuranceDate());
		u.setValidUpto(user.getValidUpto());
		return u;
	}
	
//Updating the data
	@Override
	public String updateDetails(String vehicleid,UserDTO userdto) throws VehicleMangementException{
		
		Optional<User> opt=userRepository.findById(vehicleid);
		User u=opt.orElseThrow(()->new VehicleMangementException("No data with given Vehicle Number"));
		u.setVehicleNumber(userdto.getVehicleNumber());
		u.setChassisNo(userdto.getChassisNo());
		u.setModelNo(userdto.getModelNo());
		u.setEngineNo(userdto.getEngineNo());
		u.setOwner(userdto.getOwner());
		u.setInsuranceDate(userdto.getInsuranceDate());
		u.setValidUpto(userdto.getValidUpto());
		userRepository.save(u);
		return u.getVehicleNumber();
	
	}
//Delete the data
	public void deleteDetail(String vehiclenumber) throws VehicleMangementException{
		Optional<User> user = userRepository.findById(vehiclenumber);
		user.orElseThrow(() -> new VehicleMangementException("Service.CUSTOMER_NOT_FOUND"));
		userRepository.deleteById(vehiclenumber);
		
	}
//Alerts Vehicles
	public List<UserDTO> alerts() throws VehicleMangementException{
		Iterable<User> users=userRepository.findAll();
		List<UserDTO> userdtos=new ArrayList<>();
		
		users.forEach(user->{
			if(user.getValidUpto().isBefore(LocalDate.now()) ) {
			UserDTO u=new UserDTO();
			u.setVehicleNumber(user.getVehicleNumber());
			u.setChassisNo(user.getChassisNo());
			u.setModelNo(user.getModelNo());
			u.setEngineNo(user.getEngineNo());
			u.setOwner(user.getOwner());
			u.setInsuranceDate(user.getInsuranceDate());	
			u.setValidUpto(user.getValidUpto());
		userdtos.add(u);
			}
			if(user.getValidUpto().isAfter(LocalDate.now()) && Math.abs(ChronoUnit.DAYS.between(user.getValidUpto(), LocalDate.now()))<=15) {
				UserDTO u=new UserDTO();
				u.setVehicleNumber(user.getVehicleNumber());
				u.setChassisNo(user.getChassisNo());
				u.setModelNo(user.getModelNo());
				u.setEngineNo(user.getEngineNo());
				u.setOwner(user.getOwner());
				u.setInsuranceDate(user.getInsuranceDate());	
				u.setValidUpto(user.getValidUpto());
			userdtos.add(u);
			}
		});
		return userdtos;
		
	}
	
// Alert Drivers
	
	@Override
	public List<DriverDTO> alertsDriver() throws VehicleMangementException{
		Iterable<Driver> drivers=driverrepository.findAll();
		List<DriverDTO> driverdtos=new ArrayList<>();
		drivers.forEach(driver->{
			if(driver.getLicenseExpiry().isBefore(LocalDate.now())){
				DriverDTO d=new DriverDTO();
				d.setAddress(driver.getAddress());
				d.setDriverName(driver.getDriverName());
				d.setLicenseExpiry(driver.getLicenseExpiry());
				d.setLicenseNumber(driver.getLicenseNumber());
				d.setMobileNumber(driver.getMobileNumber());
				d.setJoiningDate(driver.getJoiningDate());
				driverdtos.add(d);
			}
			if(driver.getLicenseExpiry().isAfter(LocalDate.now()) && Math.abs(ChronoUnit.DAYS.between(driver.getLicenseExpiry(), LocalDate.now()))<=15){
				DriverDTO d=new DriverDTO();
				d.setAddress(driver.getAddress());
				d.setDriverName(driver.getDriverName());
				d.setLicenseExpiry(driver.getLicenseExpiry());
				d.setLicenseNumber(driver.getLicenseNumber());
				d.setMobileNumber(driver.getMobileNumber());
				d.setJoiningDate(driver.getJoiningDate());
				driverdtos.add(d);
			}
		});
		return driverdtos;
		
	}
	
	// Add Driver
	@Override
	public String addDriver(DriverDTO driveDTO) throws VehicleMangementException {
		Driver driver = new Driver();
		
		driver.setAddress(driveDTO.getAddress());
		driver.setDriverName(driveDTO.getDriverName());
		driver.setLicenseExpiry(driveDTO.getLicenseExpiry());
		driver.setLicenseNumber(driveDTO.getLicenseNumber());
		driver.setMobileNumber(driveDTO.getMobileNumber());
		driver.setJoiningDate(driveDTO.getJoiningDate());
		driverrepository.save(driver);
		if(driveDTO.getVehicles()!=null) {
		List<UserDTO> userdtos = driveDTO.getVehicles();
		List<User> list=new ArrayList<>();
		userdtos.forEach(user->{
			User u=new User();
			u.setVehicleNumber(user.getVehicleNumber());
			u.setChassisNo(user.getChassisNo());
			u.setModelNo(user.getModelNo());
			u.setEngineNo(user.getEngineNo());
			u.setOwner(user.getOwner());
			u.setInsuranceDate(user.getInsuranceDate());	
			u.setValidUpto(user.getValidUpto());
			list.add(u);
			driver.setVehicles(list);
			driverrepository.save(driver);
			
		}
		);}
		return driver.getLicenseNumber();
		
		
	}
//	Driver Details
	@Override
	public DriverDTO getDriverDetails(String driveId) throws VehicleMangementException, UnsupportedEncodingException {
		Optional<Driver> optional = driverrepository.findById(driveId);
		Driver driver = optional.orElseThrow(()->new VehicleMangementException("No Driver found"));
		DriverDTO driveDTO = new DriverDTO();
		driveDTO.setAddress(driver.getAddress());
		driveDTO.setDriverName(driver.getDriverName());
		driveDTO.setLicenseExpiry(driver.getLicenseExpiry());
		driveDTO.setLicenseNumber(driver.getLicenseNumber());
		driveDTO.setMobileNumber(driver.getMobileNumber());
		driveDTO.setJoiningDate(driver.getJoiningDate());
		driveDTO.setAadharNumber(driver.getAadharNumber());
		driveDTO.seteMobileNumber(driver.geteMobileNumber());
		driveDTO.setPermitType(driver.getPermitType());
		driveDTO.setLicenseStart(driver.getLicenseStart());
		
		 byte[] bytes = driver.getPicByte();
		String str = new String(bytes, "UTF-8"); 
		driveDTO.setPicByte(driver.getPicByte()); 
		driveDTO.setSetPicToString(str);
		
		
		List<User> user = driver.getVehicles();
		List<UserDTO> list = new LinkedList<>();		
		
		if (!user.isEmpty()) {
			user.forEach(u->{
			UserDTO userdto=new UserDTO();
			userdto.setVehicleNumber(u.getVehicleNumber());
			userdto.setChassisNo(u.getChassisNo());
			userdto.setModelNo(u.getModelNo());
			userdto.setEngineNo(u.getEngineNo());
			userdto.setOwner(u.getOwner());
			userdto.setInsuranceDate(u.getInsuranceDate());	
			userdto.setValidUpto(u.getValidUpto());
			
			list.add(userdto);
		});
			
		}
		driveDTO.setVehicles(list);
		return driveDTO;
		
	}

// Get All driver details
	public List<DriverDTO> getAllDriverDetails() throws VehicleMangementException {
		Iterable<Driver> drivers=driverrepository.findAll();
		List<DriverDTO> list=new ArrayList<>();
		drivers.forEach(driver->{
			DriverDTO d=new DriverDTO();
			d.setDriverName(driver.getDriverName());
			d.setAddress(driver.getAddress());
			d.setLicenseExpiry(driver.getLicenseExpiry());
			d.setLicenseNumber(driver.getLicenseNumber());
			d.setMobileNumber(driver.getMobileNumber());
			d.setJoiningDate(driver.getJoiningDate());
			d.setAadharNumber(driver.getAadharNumber());
			d.seteMobileNumber(driver.geteMobileNumber());
			d.setPermitType(driver.getPermitType());
			d.setLicenseStart(driver.getLicenseStart());
			
			List<User> user = driver.getVehicles();
			List<UserDTO> list1 = new ArrayList<>();
			
			if(!user.isEmpty()) {
				
				
				user.forEach(u->{
					UserDTO userdto=new UserDTO();
					userdto.setVehicleNumber(u.getVehicleNumber());
					userdto.setChassisNo(u.getChassisNo());
					userdto.setModelNo(u.getModelNo());
					userdto.setEngineNo(u.getEngineNo());
					userdto.setOwner(u.getOwner());
					userdto.setInsuranceDate(u.getInsuranceDate());	
					userdto.setValidUpto(u.getValidUpto());
					list1.add(userdto);
//					System.out.println(userdto.getChassisNo());
					
					
				});}
//		System.out.println(userdto.getChassisNo());
			d.setVehicles(list1);
			list.add(d);
		}
		);
		;
		return list;
	}
	
//	Map Vehicle to Driver
	@Override
	public String issueVehicleToExistingDriver(String driverId, UserDTO userdto) throws VehicleMangementException {
		Optional<Driver> optional = driverrepository.findById(driverId);
		if(optional.isPresent()) {
			throw new VehicleMangementException("Data with this license number already exist");
		}
		Driver driver = optional.orElseThrow(()->new VehicleMangementException("No Drivers found"));
		User u = new User();
		
		u.setVehicleNumber(userdto.getVehicleNumber());
		u.setChassisNo(userdto.getChassisNo());
		u.setModelNo(userdto.getModelNo());
		u.setEngineNo(userdto.getEngineNo());
		u.setOwner(userdto.getOwner());
		u.setInsuranceDate(userdto.getInsuranceDate());	
		u.setValidUpto(userdto.getValidUpto());
		List<User> users=driver.getVehicles();
		System.out.println("serv");
		users.add(u);
		driver.setVehicles(users);
		driverrepository.save(driver);
		return u.getChassisNo();
		

}

//	updating driver
	@Override
	public String editDriver(String driverId,DriverDTO driveDTO,String vehicleNumber) throws VehicleMangementException, IOException {
		Optional<Driver> optional=driverrepository.findById(driverId);
		Driver driver=optional.orElseThrow(()->new VehicleMangementException("No data with given License Number"));
		driver.setAddress(driveDTO.getAddress());
		driver.setDriverName(driveDTO.getDriverName());
		driver.setLicenseExpiry(driveDTO.getLicenseExpiry());
		driver.setLicenseNumber(driveDTO.getLicenseNumber());
		driver.setMobileNumber(driveDTO.getMobileNumber());
		driver.setJoiningDate(driveDTO.getJoiningDate());
		driver.setAadharNumber(driveDTO.getAadharNumber());
		driver.seteMobileNumber(driveDTO.geteMobileNumber());
		driver.setPermitType(driveDTO.getPermitType());
		driver.setLicenseStart(driveDTO.getLicenseStart());
		driver.setPicByte(driveDTO.getPicByte());
		driverrepository.save(driver);
		
		Optional<User> opt=userRepository.findById(vehicleNumber);
		User user=opt.orElseThrow(()->new VehicleMangementException("No data with given Vehicle Number"));;
		List<User> list=new ArrayList<>();
			User u=new User();
			u.setVehicleNumber(user.getVehicleNumber());
			u.setChassisNo(user.getChassisNo());
			u.setModelNo(user.getModelNo());
			u.setEngineNo(user.getEngineNo());
			u.setOwner(user.getOwner());
			u.setInsuranceDate(user.getInsuranceDate());	
			u.setValidUpto(user.getValidUpto());
			list.add(u);
			driver.setVehicles(list);
			driverrepository.save(driver);
			
		
		return driver.getLicenseNumber();
		
	}
	
	
	
	
	@Override
	public String addDriver(DriverDTO driveDTO,String vehicleNumber) throws VehicleMangementException, IOException {
		Driver driver = new Driver();
		Optional<Driver> optional=driverrepository.findById(driveDTO.getLicenseNumber());
		if(optional.isPresent()) {
			throw new VehicleMangementException("Data with this license number already exist");
		
		}
		driver.setAddress(driveDTO.getAddress());
		driver.setDriverName(driveDTO.getDriverName());
		driver.setLicenseExpiry(driveDTO.getLicenseExpiry());
		driver.setLicenseNumber(driveDTO.getLicenseNumber());
		driver.setMobileNumber(driveDTO.getMobileNumber());
		driver.setJoiningDate(driveDTO.getJoiningDate());
		driver.setAadharNumber(driveDTO.getAadharNumber());
		driver.seteMobileNumber(driveDTO.geteMobileNumber());
		driver.setPermitType(driveDTO.getPermitType());
		driver.setLicenseStart(driveDTO.getLicenseStart());
		driver.setPicByte(driveDTO.getPicByte());
		driverrepository.save(driver);
		if(!(vehicleNumber==null)) {
		Optional<User> opt=userRepository.findById(vehicleNumber);
		User user=opt.orElseThrow(()->new VehicleMangementException("No data with given Vehicle Number"));;
		List<User> list=new ArrayList<>();
			User u=new User();
			u.setVehicleNumber(user.getVehicleNumber());
			u.setChassisNo(user.getChassisNo());
			u.setModelNo(user.getModelNo());
			u.setEngineNo(user.getEngineNo());
			u.setOwner(user.getOwner());
			u.setInsuranceDate(user.getInsuranceDate());	
			u.setValidUpto(user.getValidUpto());
			list.add(u);
			driver.setVehicles(list);
			driverrepository.save(driver);
		}else {
		
		}
		
		return driver.getLicenseNumber();
		
	}
	
	

	@Override
	public void deleteDriver(String driverId) throws VehicleMangementException {
		Optional<Driver> opt=driverrepository.findById(driverId);
		Driver driver=opt.orElseThrow(()->new VehicleMangementException("No Driver Found"));
		driver.setVehicles(null);
		driverrepository.delete(driver);
		
	}
	
//	@Override
//	public void editDriverDetails(String driverId) throws VehicleMangementException{
//		Optional<Driver> opt=driverrepository.findById(driverId);
//		Driver driver=opt.orElseThrow(()->new VehicleMangementException("No Driver Found"));
//		
//	}
	

	
	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

	
	
}


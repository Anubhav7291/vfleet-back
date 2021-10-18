package com.BBBCreation.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.BBBCreation.DTO.DriverDTO;
import com.BBBCreation.DTO.UserDTO;
import com.BBBCreation.Entity.Driver;
import com.BBBCreation.Repository.DriverRepository;
import com.BBBCreation.Service.UserService;
import com.BBBCreation.Utility.VehicleMangementException;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping(value="/")
@CrossOrigin
public class VehicleApi {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@PostMapping(value="addDetails")
	public ResponseEntity<String> addDetails(@RequestBody UserDTO userdto) throws VehicleMangementException {
		String msg=userService.addDetail(userdto);
		String message="Vehicle successfully added with vehicle number "+msg;
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping(value="/allData")
	public ResponseEntity<List<UserDTO>> getAllDetails() throws VehicleMangementException{
		List<UserDTO> data=userService.getAlldetails();
		return new ResponseEntity<List<UserDTO>>(data,HttpStatus.OK);
	}
	
	@GetMapping(value="/{vehicleNumber}")
	public ResponseEntity<UserDTO> getDetailById(@PathVariable String vehicleNumber) throws VehicleMangementException{
		UserDTO user=userService.getDetailsbyId(vehicleNumber);
		return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
	}
	
	@PutMapping(value="/edit/{vehicleNumber}")
	public ResponseEntity<String> updatedetail(@PathVariable String vehicleNumber,@RequestBody UserDTO userdto) throws VehicleMangementException{
		userService.updateDetails(vehicleNumber,userdto);
		String message="Successfully edited with Vehicle Id "+ userdto.getVehicleNumber();
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{vehicleNumber}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteDetail(@PathVariable String vehicleNumber) throws VehicleMangementException{
		userService.deleteDetail(vehicleNumber);
		String successMessage = "Successfully deleted";
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}
//	Map Driver To Vehicle
	@PostMapping(value="addDetails/{driverId}")
	public ResponseEntity<String> addDetailsWithDriver(@RequestBody UserDTO userdto,@PathVariable String driverId) throws VehicleMangementException {
		String msg=userService.addDetailWithDriver(userdto, driverId);
		String message="Vehicle successfully added with vehicle number "+msg;
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping(value="/alerts")
	public ResponseEntity<List<UserDTO>> alerts() throws VehicleMangementException{
		List<UserDTO> user=userService.alerts();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
                           /* Driver Apis*/
	
//	Map Vehicle to Driver
	@PutMapping(value="/addVehicleToDriver/{driverId}")
	public ResponseEntity<String> issueVehichleToDriver(@PathVariable String driverId, @RequestBody UserDTO userdto) throws VehicleMangementException{
		String m=userService.issueVehicleToExistingDriver(driverId,userdto);

		return new ResponseEntity<String>(m,HttpStatus.OK);
	}
	
//	Driver Details by Id
	@GetMapping(value="/driverDetail/{driverId}")
	public ResponseEntity<DriverDTO> getDriverDetails(@PathVariable String driverId) throws VehicleMangementException, UnsupportedEncodingException{
		DriverDTO data=userService.getDriverDetails(driverId);
		return new ResponseEntity<DriverDTO>(data,HttpStatus.OK);
	}
	
//	All Driver Details 
	@GetMapping(value="/driverAllDetail")
	public ResponseEntity<List<DriverDTO>> getDriverAllDetails() throws VehicleMangementException{
		List<DriverDTO> data=userService.getAllDriverDetails();
		return new ResponseEntity<List<DriverDTO>>(data,HttpStatus.OK);
	}
	
	
// Add Driver
//	@PostMapping(value="/addDriverDetails")
//	public ResponseEntity<String> addDriverDetails(@RequestBody DriverDTO driverDTO) throws VehicleMangementException{
//		String msg=userService.addDriver(driverDTO);
//		String message="Driver Successfully Added with license Number "+msg;
//		return new ResponseEntity<String>(message,HttpStatus.OK);
//	}
	
	@PostMapping(value={"/addDriverDetails","/addDriverDetails/{vehicleId}"})
	public ResponseEntity<String> addDriverDetails(@ModelAttribute  DriverDTO driverDTO,@PathVariable(required=false) String vehicleId ) throws VehicleMangementException, IOException{
		System.out.println(driverDTO.getPicByte());
		String msg=userService.addDriver(driverDTO, vehicleId);
		String message="Driver Successfully Added with license Number "+msg;
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteDriver/{driverId}")
	public ResponseEntity<String> deleteDriver(@PathVariable String driverId) throws VehicleMangementException{
		userService.deleteDriver(driverId);
		String message="Deleted Successfully";
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	@GetMapping(value="/driverAlerts")
	public  ResponseEntity<List<DriverDTO>> driveralerts() throws VehicleMangementException{
		List<DriverDTO> list=userService.alertsDriver();
		return new ResponseEntity<List<DriverDTO>>(list,HttpStatus.OK);
	}
	@PutMapping(value="/driveredit/{driverId}/{vehicleNumber}")
	public ResponseEntity<String> editDriver(@PathVariable String driverId ,@PathVariable String vehicleNumber,@ModelAttribute DriverDTO driverdto) throws VehicleMangementException, IOException{
		userService.editDriver(driverId, driverdto, vehicleNumber);
		String message="Successfully edited with Vehicle Id "+ driverId;
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}}


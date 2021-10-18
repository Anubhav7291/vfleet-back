package com.BBBCreation.Utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {
	
	@ExceptionHandler(VehicleMangementException.class)
	public ResponseEntity<ErrorInfo> BBBCreationException(VehicleMangementException exception){
		ErrorInfo error=new ErrorInfo();
		error.setErrorMessage(exception.getMessage());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.NOT_FOUND);
	}
}

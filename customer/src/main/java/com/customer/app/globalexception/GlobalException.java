package com.customer.app.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.customer.app.customeexceptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalException {

	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<Object> exception(ResourceNotFoundException exception) {
		 return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
	}
	
}

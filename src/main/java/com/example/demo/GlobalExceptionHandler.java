package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<?> customException(CustomerException ex) {
		Map<String, Object> map = new HashMap<>();
		map.getOrDefault("customerId", ex.getCustomerId());
		map.put("errorField", ex.getError());
		map.put("errorMessage", ex.getErrorMessage());
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		
	}
}

package com.example.demo;

import lombok.Data;

@Data
public class CustomerException extends RuntimeException{

	private Integer customerId;
	private String error;
	private String errorMessage;
	
	public CustomerException(Integer customerId, String error, String errorMessage) {
		super(errorMessage);
		this.customerId = customerId;
		this.error = error;
		this.errorMessage = errorMessage;
	}
}

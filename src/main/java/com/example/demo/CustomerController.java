package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	private CustomerService service;
	
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@PostMapping(path = "/customer/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> create(@RequestBody(required = true) Customer customer) {
		Customer response = service.create(customer);
		return ResponseEntity.ok().body(response);
	}

}

package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@GetMapping(path = "/customer")
	public ResponseEntity<String> welcomeCustomer() {
		return ResponseEntity.ok("Welcome to Customer Project");
	}

}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private CustomerRepository customerRepo;
	
	@Autowired
	public void setCustomerRepo(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	public Customer create(Customer customer) {
		if (!org.springframework.util.CollectionUtils.isEmpty(customer.getAddress())) {
			customer.getAddress().stream().forEach(add -> add.setCustomer(customer));
		} else {
			throw new CustomerException(customer.getId(), "address", "no address object in customer");
		}
		Customer custom = customerRepo.save(customer);
		return custom;
	}
}

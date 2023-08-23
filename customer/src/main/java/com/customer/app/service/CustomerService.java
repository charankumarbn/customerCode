package com.customer.app.service;

import org.springframework.http.ResponseEntity;

import com.customer.app.entity.Customer;
import com.customer.app.essential.ResponseData;

public interface CustomerService {

	
	public ResponseEntity<ResponseData> createCustomer(Customer customer);
	public ResponseEntity<ResponseData> findById(Long customerId);

}

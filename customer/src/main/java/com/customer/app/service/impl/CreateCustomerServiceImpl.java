package com.customer.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customer.app.customeexceptions.ResourceNotFoundException;
import com.customer.app.entity.Customer;
import com.customer.app.essential.ResponseData;
import com.customer.app.repo.CustomerRepo;
import com.customer.app.service.CustomerService;

@Service
public class CreateCustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public ResponseEntity<ResponseData> createCustomer(Customer customer){
		ResponseData data = new ResponseData();
		System.out.println(customer);
		try {
		customerRepo.saveAndFlush(customer);
		data.setMessage("Succesfully user created");
		data.setStatus(true);
		}catch (Exception e) {
			data.setMessage(e.getMessage());
			data.setStatus(false);
		}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	
	@Override
	public ResponseEntity<ResponseData> findById(Long customerId){
		ResponseData data = new ResponseData();
	//	.orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
		try {
			 Customer customelist = customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer details not found"));
			data.setMessage("Succesfully got the customer details");
			data.setStatus(true);
			data.setData(customelist);
			}catch (Exception e) {
				data.setMessage(e.getMessage());
				data.setStatus(false);
			}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
}

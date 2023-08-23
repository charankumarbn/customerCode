package com.customer.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.app.entity.Customer;
import com.customer.app.essential.ResponseData;
import com.customer.app.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping(value = "addCustomer")
	public ResponseEntity<ResponseData> createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<ResponseData> getCustomer(@Valid @PathVariable Long customerId) {
		return customerService.findById(customerId);
	}

}

package com.customer.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customer.app.entity.CreditCardApplication;
import com.customer.app.entity.Customer;
import com.customer.app.essential.ResponseData;
import com.customer.app.repo.CreditCardApplicationRepo;
import com.customer.app.service.CreditCardApplicationService;

@Service
public class CreditCardApplicationServiceImpl implements CreditCardApplicationService {

	@Autowired
	CreditCardApplicationRepo creditCardApplicationRepo;

	@Override
	public ResponseEntity<ResponseData> applyForCreditCard(CreditCardApplication application) {
		ResponseData data = new ResponseData();
		try {
			creditCardApplicationRepo.saveAndFlush(application);
			data.setMessage("Successfully applied for credit card");
			data.setStatus(true);
		} catch (Exception e) {
			data.setMessage("Failed applied for credit card");
			data.setStatus(false);
		}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	@Override
	public List<CreditCardApplication> findByCustomer(Customer customer) {
		return creditCardApplicationRepo.findByCustomer(customer);
	}

	@Override
	public ResponseEntity<ResponseData> getPendingCards() {
		String status = "Pending";
		ResponseData data = new ResponseData();
		try {
			List<CreditCardApplication> response = creditCardApplicationRepo.findByStatus(status);
			data.setStatus(true);
			data.setData(response);
			data.setMessage("Succesfully got all data");
		} catch (Exception e) {
			data.setMessage("Failed to get data");
			data.setStatus(false);
		}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	@Override
	public ResponseEntity<ResponseData> getAllCards() {
		ResponseData data = new ResponseData();
		try {
			List<CreditCardApplication> response = creditCardApplicationRepo.findAll();
			data.setStatus(true);
			data.setData(response);
			data.setMessage("Succesfully got all data");
		} catch (Exception e) {
			data.setMessage("Failed to get data");
			data.setStatus(false);
		}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	@Override
	public ResponseEntity<ResponseData> updateStatus(CreditCardApplication application) {
		ResponseData data = new ResponseData();
		try {
			creditCardApplicationRepo.save(application);
			data.setStatus(true);
			data.setMessage("Succesfully updated the data");
		} catch (Exception e) {
			data.setStatus(false);
			data.setMessage("Failed to updated the data");
		}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
}

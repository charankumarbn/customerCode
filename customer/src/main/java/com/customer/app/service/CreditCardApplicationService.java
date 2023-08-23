package com.customer.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.customer.app.entity.CreditCardApplication;
import com.customer.app.entity.Customer;
import com.customer.app.essential.ResponseData;

public interface CreditCardApplicationService {
	
	ResponseEntity<ResponseData> applyForCreditCard(CreditCardApplication application);
	
	 List<CreditCardApplication> findByCustomer(Customer customer);
	 
	 ResponseEntity<ResponseData> getPendingCards();
	 
	 ResponseEntity<ResponseData> getAllCards();
	 
	 ResponseEntity<ResponseData> updateStatus(CreditCardApplication application);

}

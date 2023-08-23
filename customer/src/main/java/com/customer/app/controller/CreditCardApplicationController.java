package com.customer.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.app.entity.CreditCardApplication;
import com.customer.app.entity.Customer;
import com.customer.app.essential.ResponseData;
import com.customer.app.service.CreditCardApplicationService;

@RestController
@RequestMapping("/application")
public class CreditCardApplicationController {

	
	    @Autowired
	    private CreditCardApplicationService creditCardApplicationService;
	    
	    @PostMapping(value="/apply")
	    public ResponseEntity<ResponseData> applyForCreditCard( @Valid @RequestBody CreditCardApplication application) {
	        // Perform verification process here
	        application.setStatus("Pending");
	        return creditCardApplicationService.applyForCreditCard(application);
	    }
	    
	    
	    @GetMapping("/customer/{customerId}")
	    public List<CreditCardApplication> getApplicationsForCustomer(@Valid @PathVariable Long customerId) {
	        Customer customer = new Customer();
	        customer.setId(customerId);
	        return creditCardApplicationService.findByCustomer(customer);
	    }
	    
	    @GetMapping("/pendingCards")
	    public ResponseEntity<ResponseData> getPendingCards() {
	        return creditCardApplicationService.getPendingCards();
	    }
	    
	    @GetMapping("/getAllCards")
	    public ResponseEntity<ResponseData> getAllCards() {
	        return creditCardApplicationService.getAllCards();
	    }
	    
	    @PutMapping("/updateStatus")
	    public ResponseEntity<ResponseData> updateStatus(@RequestBody CreditCardApplication application){
	    	return creditCardApplicationService.updateStatus(application);
	    }
}

package com.customer.customer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.customer.app.controller.CustomerController;
import com.customer.app.entity.Customer;
import com.customer.app.essential.ResponseData;
import com.customer.app.service.CustomerService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerControllerTest {
	

	    @InjectMocks
	    private CustomerController customerController;

	    @Mock
	    private CustomerService customerService;

	    @Test
	    public void testCreateCustomer_Success() {
	        Customer customer = new Customer(); // Create a test customer
	        ResponseData expectedResponse = new ResponseData();
	        expectedResponse.setStatus(true);
	        expectedResponse.setMessage("Successfully user created");

	        when(customerService.createCustomer(customer)).thenReturn(ResponseEntity.ok(expectedResponse));

	        ResponseEntity<ResponseData> response = customerController.createCustomer(customer);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(expectedResponse, response.getBody());
	    }

	    @Test
	    public void testGetCustomer_Success() {
	        Long customerId = 1L;
	        Customer expectedCustomer = new Customer(); // Create a test customer
	        ResponseData expectedResponse = new ResponseData();
	        expectedResponse.setStatus(true);
	        expectedResponse.setMessage("Successfully got the customer details");
	        expectedResponse.setData(expectedCustomer);

	        when(customerService.findById(customerId)).thenReturn(ResponseEntity.ok(expectedResponse));

	        ResponseEntity<ResponseData> response = customerController.getCustomer(customerId);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(expectedResponse, response.getBody());
	    }

	    @Test
	    public void testGetCustomer_Failure() {
	        Long customerId = 1L;
	        ResponseData expectedResponse = new ResponseData();
	        expectedResponse.setStatus(false);
	        expectedResponse.setMessage("ResourceNotFoundException message");

	        when(customerService.findById(customerId)).thenReturn(ResponseEntity.status(HttpStatus.NOT_FOUND).body(expectedResponse));

	        ResponseEntity<ResponseData> response = customerController.getCustomer(customerId);

	        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	        assertEquals(expectedResponse, response.getBody());
	    }


}

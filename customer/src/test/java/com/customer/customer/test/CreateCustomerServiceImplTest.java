package com.customer.customer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

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

import com.customer.app.entity.Customer;
import com.customer.app.essential.ResponseData;
import com.customer.app.repo.CustomerRepo;
import com.customer.app.service.impl.CreateCustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreateCustomerServiceImplTest {
	

	    @InjectMocks
	    private CreateCustomerServiceImpl customerService;

	    @Mock
	    private CustomerRepo customerRepo;

	    @Test
	    public void testCreateCustomer_Success() {
	        Customer customer = new Customer(); // Create a test customer
	        ResponseData expectedResponse = new ResponseData();
	        expectedResponse.setStatus(true);
	        expectedResponse.setMessage("Successfully user created");

	        when(customerRepo.saveAndFlush(customer)).thenReturn(customer);

	        ResponseEntity<ResponseData> response = customerService.createCustomer(customer);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	    }

	    @Test
	    public void testCreateCustomer_Failure() {
	        Customer customer = new Customer(); // Create a test customer
	        ResponseData expectedResponse = new ResponseData();
	        expectedResponse.setStatus(false);
	        expectedResponse.setMessage("Error message from exception");

	        when(customerRepo.saveAndFlush(customer)).thenThrow(new RuntimeException("Error message from exception"));

	        ResponseEntity<ResponseData> response = customerService.createCustomer(customer);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	    }

	    @Test
	    public void testFindById_Success() {
	        Long customerId = 1L;
	        Customer expectedCustomer = new Customer(); // Create a test customer
	        ResponseData expectedResponse = new ResponseData();
	        expectedResponse.setStatus(true);
	        expectedResponse.setMessage("Successfully got the customer details");
	        expectedResponse.setData(expectedCustomer);

	        when(customerRepo.findById(customerId)).thenReturn(Optional.of(expectedCustomer));

	        ResponseEntity<ResponseData> response = customerService.findById(customerId);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	    }

	   


}

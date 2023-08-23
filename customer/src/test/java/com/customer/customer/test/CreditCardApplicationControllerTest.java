package com.customer.customer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

import com.customer.app.controller.CreditCardApplicationController;
import com.customer.app.entity.CreditCardApplication;
import com.customer.app.essential.ResponseData;
import com.customer.app.service.CreditCardApplicationService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreditCardApplicationControllerTest {
	

	    @InjectMocks
	    private CreditCardApplicationController creditCardApplicationController;

	    @Mock
	    private CreditCardApplicationService creditCardApplicationService;

	    @Test
	    public void testApplyForCreditCard_Success() {
	        CreditCardApplication application = new CreditCardApplication(); // Create a test application
	        ResponseData expectedResponse = new ResponseData();
	        expectedResponse.setStatus(true);
	        expectedResponse.setMessage("Successfully applied for credit card");

	        when(creditCardApplicationService.applyForCreditCard(application)).thenReturn(ResponseEntity.ok(expectedResponse));

	        ResponseEntity<ResponseData> response = creditCardApplicationController.applyForCreditCard(application);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(expectedResponse, response.getBody());
	    }

	    @Test
	    public void testGetApplicationsForCustomer() {
	        Long customerId = 1L;
	        List<CreditCardApplication> expectedApplications = new ArrayList<>(); // Create expected application list

	        when(creditCardApplicationService.findByCustomer(any())).thenReturn(expectedApplications);

	        List<CreditCardApplication> result = creditCardApplicationController.getApplicationsForCustomer(customerId);

	        assertEquals(expectedApplications, result);
	    }

	    @Test
	    public void testGetPendingCards() {
	        ResponseData expectedResponse = new ResponseData();
	        expectedResponse.setStatus(true);
	        expectedResponse.setMessage("Response message");

	        when(creditCardApplicationService.getPendingCards()).thenReturn(ResponseEntity.ok(expectedResponse));

	        ResponseEntity<ResponseData> response = creditCardApplicationController.getPendingCards();

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(expectedResponse, response.getBody());
	    }

	    @Test
	    public void testGetAllCards() {
	        ResponseData expectedResponse = new ResponseData();
	        expectedResponse.setStatus(true);
	        expectedResponse.setMessage("Response message");

	        when(creditCardApplicationService.getAllCards()).thenReturn(ResponseEntity.ok(expectedResponse));

	        ResponseEntity<ResponseData> response = creditCardApplicationController.getAllCards();

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(expectedResponse, response.getBody());
	    }

	    @Test
	    public void testUpdateStatus() {
	        CreditCardApplication application = new CreditCardApplication(); // Create a test application
	        ResponseData expectedResponse = new ResponseData();
	        expectedResponse.setStatus(true);
	        expectedResponse.setMessage("Response message");

	        when(creditCardApplicationService.updateStatus(application)).thenReturn(ResponseEntity.ok(expectedResponse));

	        ResponseEntity<ResponseData> response = creditCardApplicationController.updateStatus(application);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(expectedResponse, response.getBody());
	    }


}

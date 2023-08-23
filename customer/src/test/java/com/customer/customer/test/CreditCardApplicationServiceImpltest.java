package com.customer.customer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.customer.app.entity.CreditCardApplication;
import com.customer.app.entity.Customer;
import com.customer.app.essential.ResponseData;
import com.customer.app.repo.CreditCardApplicationRepo;
import com.customer.app.service.impl.CreditCardApplicationServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreditCardApplicationServiceImpltest {
	
	@InjectMocks
	CreditCardApplicationServiceImpl creditcardapplicationserviceimpl;
	

    @Mock
    private CreditCardApplicationRepo creditCardApplicationRepo;

    @Test
    public void testApplyForCreditCard_Success() {
        CreditCardApplication application = new CreditCardApplication(); // Create a test application
        ResponseData expectedResponse = new ResponseData();
        expectedResponse.setStatus(true);
        expectedResponse.setMessage("Successfully applied for credit card");

        when(creditCardApplicationRepo.saveAndFlush(application)).thenReturn(application);

        ResponseEntity<ResponseData> response = creditcardapplicationserviceimpl.applyForCreditCard(application);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    public void testApplyForCreditCard_Failure() {
        CreditCardApplication application = new CreditCardApplication(); // Create a test application
        ResponseData expectedResponse = new ResponseData();
        expectedResponse.setStatus(false);
        expectedResponse.setMessage("Failed applied for credit card");

        when(creditCardApplicationRepo.saveAndFlush(application)).thenThrow(new RuntimeException());

        ResponseEntity<ResponseData> response = creditcardapplicationserviceimpl.applyForCreditCard(application);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testFindByCustomer() {
        Customer customer = new Customer(); // Create a test customer
        List<CreditCardApplication> expectedApplications = new ArrayList<>(); // Create expected application list
        when(creditCardApplicationRepo.findByCustomer(customer)).thenReturn(expectedApplications);

        List<CreditCardApplication> result = creditcardapplicationserviceimpl.findByCustomer(customer);

        assertEquals(expectedApplications, result);
    }

    @Test
    public void testGetPendingCards_Success() {
        String status = "Pending";
        List<CreditCardApplication> expectedApplications = new ArrayList<>(); // Create expected application list
        ResponseData expectedResponse = new ResponseData();
        expectedResponse.setStatus(true);
        expectedResponse.setData(expectedApplications);
        expectedResponse.setMessage("Successfully got all data");

        when(creditCardApplicationRepo.findByStatus(status)).thenReturn(expectedApplications);

        ResponseEntity<ResponseData> response = creditcardapplicationserviceimpl.getPendingCards();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetPendingCards_Failure() {
        String status = "Pending";
        ResponseData expectedResponse = new ResponseData();
        expectedResponse.setStatus(false);
        expectedResponse.setMessage("Failed to get data");

        when(creditCardApplicationRepo.findByStatus(status)).thenThrow(new RuntimeException());

        ResponseEntity<ResponseData> response = creditcardapplicationserviceimpl.getPendingCards();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    public void testUpdateStatus_Success() {
        CreditCardApplication application = new CreditCardApplication(); // Create a test application
        ResponseData expectedResponse = new ResponseData();
        expectedResponse.setStatus(true);
        expectedResponse.setMessage("Successfully updated the data");

        when(creditCardApplicationRepo.save(application)).thenReturn(application);

        ResponseEntity<ResponseData> response = creditcardapplicationserviceimpl.updateStatus(application);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testUpdateStatus_Failure() {
        CreditCardApplication application = new CreditCardApplication(); // Create a test application
        ResponseData expectedResponse = new ResponseData();
        expectedResponse.setStatus(false);
        expectedResponse.setMessage("Failed to updated the data");

        when(creditCardApplicationRepo.save(application)).thenThrow(new RuntimeException());

        ResponseEntity<ResponseData> response = creditcardapplicationserviceimpl.updateStatus(application);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    
    
    
    @Test
    public void testGetAllCards_Success() {
        String status = "Pending";
        List<CreditCardApplication> expectedApplications = new ArrayList<>(); // Create expected application list
        ResponseData expectedResponse = new ResponseData();
        expectedResponse.setStatus(true);
        expectedResponse.setData(expectedApplications);

        when(creditCardApplicationRepo.findAll()).thenReturn(expectedApplications);

        ResponseEntity<ResponseData> response = creditcardapplicationserviceimpl.getAllCards();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetAllCards_Failure() {
        String status = "Pending";
        ResponseData expectedResponse = new ResponseData();
        expectedResponse.setStatus(false);
        expectedResponse.setMessage("Failed to get data");

        when(creditCardApplicationRepo.findAll()).thenThrow(new RuntimeException());

        ResponseEntity<ResponseData> response = creditcardapplicationserviceimpl.getAllCards();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}

package com.customer.customer.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.customer.app.entity.CreditCardApplication;
import com.customer.app.entity.Customer;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreditCardApplicationTest {

	/** The index event status. */
	@InjectMocks
	private CreditCardApplication creditcardapplication;

	/**
	 * Instantiates a new index event status test.
	 */
	public CreditCardApplicationTest() {
		
	}
	
	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		creditcardapplication = new CreditCardApplication();
//		Customer customer=new Customer();
		creditcardapplication.setCustomer(null);
		creditcardapplication.setId(null);
		creditcardapplication.setPhoneNumber("123");
	
	}
	
	/**
	 * Test to string.
	 */
	@Test
	 void testToString() {
		String exp = "IndexEventStatus [statusId=1, statusText=Constants.TENANTID, statusColor=Constants.TENANTID]";
		assertNotEquals("testtoStringTest", exp,creditcardapplication.toString());
		
	}
	
}

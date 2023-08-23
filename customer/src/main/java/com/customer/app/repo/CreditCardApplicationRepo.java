package com.customer.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.app.entity.CreditCardApplication;
import com.customer.app.entity.Customer;

public interface CreditCardApplicationRepo extends JpaRepository<CreditCardApplication, Long> {
	List<CreditCardApplication> findByCustomer(Customer customer);
	List<CreditCardApplication> findByStatus(String status);
}

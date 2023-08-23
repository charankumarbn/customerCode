package com.customer.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.app.entity.Customer;


public interface CustomerRepo extends JpaRepository<Customer,Long> {

}

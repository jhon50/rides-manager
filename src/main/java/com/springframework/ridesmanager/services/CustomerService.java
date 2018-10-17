package com.springframework.ridesmanager.services;

import com.springframework.ridesmanager.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer findCustomerById(Long id);

    List<Customer> findAllCustomers();
}
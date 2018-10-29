package com.springframework.ridesmanager.services;

import com.springframework.ridesmanager.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface CustomerService {

    Customer findCustomerById(String id);

    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer findFirstByPhone(String phone);

}
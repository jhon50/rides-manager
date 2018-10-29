package com.springframework.ridesmanager.repositories;

import com.springframework.ridesmanager.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Collection;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findFirstByPhone(String lastname);
}

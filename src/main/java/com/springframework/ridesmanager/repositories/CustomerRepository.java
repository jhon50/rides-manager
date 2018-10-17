package com.springframework.ridesmanager.repositories;

import com.springframework.ridesmanager.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

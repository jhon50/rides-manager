package com.springframework.ridesmanager.repositories;

import com.springframework.ridesmanager.domain.CustomerRide;
import com.springframework.ridesmanager.domain.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRideRepository extends JpaRepository<CustomerRide, Long> {
}

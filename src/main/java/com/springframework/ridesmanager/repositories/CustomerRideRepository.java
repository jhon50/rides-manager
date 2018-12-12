package com.springframework.ridesmanager.repositories;

import com.springframework.ridesmanager.domain.CustomerRide;
import com.springframework.ridesmanager.domain.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRideRepository extends JpaRepository<CustomerRide, Long> {
    List<CustomerRide> findAllByCustomerId(String id);
    List<CustomerRide> findAllByRideId(Long rideId);
    List<CustomerRide> findAllByRide(Ride ride);
}

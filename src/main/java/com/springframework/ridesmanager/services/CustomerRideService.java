package com.springframework.ridesmanager.services;

import com.springframework.ridesmanager.domain.CustomerRide;
import com.springframework.ridesmanager.domain.Ride;

import java.util.List;

public interface CustomerRideService {

    CustomerRide findCustomerRideById(Long id);

    List<CustomerRide> findAllCustomerRides(String id);

    List<CustomerRide> findAllCustomerRides(Long rideId);

    CustomerRide saveCustomerRide(CustomerRide customerRide);
}
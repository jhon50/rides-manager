package com.springframework.ridesmanager.services;

import com.springframework.ridesmanager.domain.Customer;
import com.springframework.ridesmanager.domain.Ride;

import java.util.List;

public interface RideService {

    Ride findRideById(Long id);

    List<Ride> findAllRides();

    Integer customerRidesCount(Ride ride);

    Ride saveRide(Ride ride);
}
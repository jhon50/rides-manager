package com.springframework.ridesmanager.services;

import com.springframework.ridesmanager.domain.Customer;
import com.springframework.ridesmanager.domain.Ride;
import com.springframework.ridesmanager.repositories.CustomerRepository;
import com.springframework.ridesmanager.repositories.CustomerRideRepository;
import com.springframework.ridesmanager.repositories.RideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final CustomerRideRepository customerRideRepository;

    public RideServiceImpl(RideRepository rideRepository, CustomerRideRepository customerRideRepository) {

        this.rideRepository = rideRepository;
        this.customerRideRepository = customerRideRepository;
    }

    @Override
    public Ride findRideById(Long id) {
        return rideRepository.findById(id).get();
    }

    @Override
    public List<Ride> findAllRides() {
        return rideRepository.findAll();
    }

    @Override
    public Integer customerRidesCount(Ride ride) {
        return customerRideRepository.findAllByRide(ride).size();
    }

    @Override
    public Ride saveRide(Ride ride) {
        return rideRepository.save(ride);
    }

}

package com.springframework.ridesmanager.services;

import com.springframework.ridesmanager.domain.Customer;
import com.springframework.ridesmanager.domain.Ride;
import com.springframework.ridesmanager.repositories.CustomerRepository;
import com.springframework.ridesmanager.repositories.RideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;

    public RideServiceImpl(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
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
    public Ride saveRide(Ride ride) {
        return rideRepository.save(ride);
    }

}

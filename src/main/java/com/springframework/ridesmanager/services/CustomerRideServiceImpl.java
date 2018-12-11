package com.springframework.ridesmanager.services;

import com.springframework.ridesmanager.domain.Customer;
import com.springframework.ridesmanager.domain.CustomerRide;
import com.springframework.ridesmanager.repositories.CustomerRepository;
import com.springframework.ridesmanager.repositories.CustomerRideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRideServiceImpl implements CustomerRideService {

    private final CustomerRideRepository customerRideRepository;

    public CustomerRideServiceImpl(CustomerRideRepository customerRideRepository) {
        this.customerRideRepository = customerRideRepository;
    }

    @Override
    public CustomerRide findCustomerRideById(Long id) {
        return customerRideRepository.findById(id).get();
    }

    @Override
    public List<CustomerRide> findAllCustomerRides(String id) {
        return customerRideRepository.findAllByCustomerId(id);
    }

    @Override
    public CustomerRide saveCustomerRide(CustomerRide customerRide) {
        return customerRideRepository.save(customerRide);
    }

}

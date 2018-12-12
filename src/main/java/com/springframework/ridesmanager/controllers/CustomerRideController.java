package com.springframework.ridesmanager.controllers;

import com.springframework.ridesmanager.domain.Customer;
import com.springframework.ridesmanager.domain.CustomerRide;
import com.springframework.ridesmanager.domain.Rating;
import com.springframework.ridesmanager.domain.Ride;
import com.springframework.ridesmanager.services.CustomerRideService;
import com.springframework.ridesmanager.services.CustomerService;
import com.springframework.ridesmanager.services.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(CustomerRideController.BASE_URL)
public class CustomerRideController {

    public static final String BASE_URL = "/api/v1/customer_rides";
    private final RideService rideService;
    private final CustomerRideService customerRideService;
    private final CustomerService customerService;

    public CustomerRideController(RideService rideService, CustomerService customerService, CustomerRideService customerRideService) {
        this.rideService = rideService;
        this.customerService = customerService;
        this.customerRideService = customerRideService;
    }

    @GetMapping("/{id}")
    List<CustomerRide> getAllCustomerRides(@PathVariable String id) {

        List<CustomerRide> customerRides = customerRideService.findAllCustomerRides(id);
        for (CustomerRide customerRide  : customerRides) {
            customerRide.getRide().setSlots(rideService.customerRidesCount(customerRide.getRide()) - 1);
        }

        return customerRideService.findAllCustomerRides(id);
    }

    @GetMapping("/ride/{ride_id}")
    List<CustomerRide> getRideCustomerRides(@PathVariable Long ride_id) {
        return customerRideService.findAllCustomerRides(ride_id);
    }

//    @GetMapping("/{id}")
//    public CustomerRide getCustomerRideById(@PathVariable Long id) {
//        return customerRideService.findCustomerRideById(id);
//    }

    @PostMapping("/rate")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerRide saveCustomerRideRating(@RequestBody Rating payload) {
        CustomerRide customerRide = customerRideService.findCustomerRideById(payload.getCustomer_ride_id());
        customerRide.setRating(payload.getRating());
        return customerRideService.saveCustomerRide(customerRide);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerRide saveCustomerRide(@RequestBody CustomerRide customerRide) {

        Ride ride = rideService.findRideById(Long.parseLong(customerRide.getRide_id()));
        List<CustomerRide> customer_rides = customerRideService.findAllCustomerRides(ride.getId());

        if(customer_rides.size() >= 5) {
            return null;
        }

        String authentication_token = customerRide.getAuthentication_token();
        Customer customer = customerService.findCustomerById(authentication_token);

        customerRide.setCustomer(customer);
        customerRide.setRide(ride);

        return customerRideService.saveCustomerRide(customerRide);
    }

}



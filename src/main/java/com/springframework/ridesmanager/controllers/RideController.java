package com.springframework.ridesmanager.controllers;

import com.springframework.ridesmanager.domain.Customer;
import com.springframework.ridesmanager.domain.CustomerRide;
import com.springframework.ridesmanager.domain.Ride;
import com.springframework.ridesmanager.services.CustomerRideService;
import com.springframework.ridesmanager.services.CustomerService;
import com.springframework.ridesmanager.services.RideService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(RideController.BASE_URL)
public class RideController {

    public static final String BASE_URL = "/api/v1/rides";
    private final RideService rideService;
    private final CustomerService customerService;
    private final CustomerRideService customerRideService;

    public RideController(RideService rideService, CustomerService customerService, CustomerRideService customerRideService) {
        this.rideService = rideService;
        this.customerService = customerService;
        this.customerRideService = customerRideService;
    }

    @GetMapping
    List<Ride> getAllRides() {

        List<Ride> rides = rideService.findAllRides();
        for (Ride ride  : rides) {
            ride.setSlots(rideService.customerRidesCount(ride) - 1);
        }

        return rides;
    }

    @GetMapping("/{id}")
    public Ride getRideById(@PathVariable Long id) {
        return rideService.findRideById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ride saveRide(@RequestBody Ride ride) {
        String authentication_token = ride.getAuthentication_token();
        Customer customer = customerService.findCustomerById(authentication_token);
        ride.setCustomer(customer);
        ride = rideService.saveRide(ride);

        // Add customer to its own ride
        CustomerRide customerRide = new CustomerRide();
        customerRide.setRide(ride);
        customerRide.setCustomer(customer);
        customerRideService.saveCustomerRide(customerRide);

        return ride;
    }

}



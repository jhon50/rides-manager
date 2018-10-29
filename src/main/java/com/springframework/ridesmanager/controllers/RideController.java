package com.springframework.ridesmanager.controllers;

import com.springframework.ridesmanager.domain.Customer;
import com.springframework.ridesmanager.domain.Ride;
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

    public RideController(RideService rideService, CustomerService customerService) {
        this.rideService = rideService;
        this.customerService = customerService;
    }

    @GetMapping
    List<Ride> getAllRides() {
        return rideService.findAllRides();
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
        return rideService.saveRide(ride);
    }

}



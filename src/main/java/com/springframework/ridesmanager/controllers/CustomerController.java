package com.springframework.ridesmanager.controllers;

import com.springframework.ridesmanager.domain.Customer;
import com.springframework.ridesmanager.services.CustomerService;
import org.hibernate.id.GUIDGenerator;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/login")
    public String login(@RequestBody String phone) {
        JSONObject obj = new JSONObject(phone);
        Customer customer = customerService.findFirstByPhone(obj.getString("phone"));
        if(customer == null) {
            return "Usuário não encontrado.";
        }
        return customer.getId();
    }
}



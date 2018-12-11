package com.springframework.ridesmanager.bootstrap;

import com.springframework.ridesmanager.domain.Customer;
import com.springframework.ridesmanager.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicializando Usuários.");
        Customer c1 = new Customer();
        c1.setFirstname("Joao");
        c1.setLastname("Paulo");
        c1.setPhone("12341234");
        c1.setId(UUID.randomUUID().toString());
        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setFirstname("Joao");
        c2.setLastname("Paulo");
        c2.setPhone("99999999");
        c2.setId(UUID.randomUUID().toString());

        customerRepository.save(c2);

//        System.out.println(customerRepository.count());
        System.out.println("Usuários salvos: " + customerRepository.count());
    }
}

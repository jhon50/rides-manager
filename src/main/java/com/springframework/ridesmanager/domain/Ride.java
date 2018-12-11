package com.springframework.ridesmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springframework.ridesmanager.repositories.RideRepository;
import com.springframework.ridesmanager.services.RideService;
import com.springframework.ridesmanager.services.RideServiceImpl;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@Entity
public class Ride {

    @Transient
    private String authentication_token;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String start_time;
    private String origin;
    private String destination;

    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    private Customer customer;

    @Transient
    private Integer slots;
}

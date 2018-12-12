package com.springframework.ridesmanager.domain;

import lombok.Data;


@Data
public class Rating {

    private Long customer_ride_id;
    private Integer rating;
}

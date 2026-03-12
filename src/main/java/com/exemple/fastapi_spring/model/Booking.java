package com.exemple.fastapi_spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class Booking {
    private String nom;
    private String telephone;
    private String email;
    private Integer numeroChambre;
    private String description;
    private Instant dateReservation;

}

package com.hospify.main.entity;

import jakarta.persistence.*;
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long countryId;

    private String countryName;
}

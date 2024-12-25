package com.hospify.main.entity;

import jakarta.persistence.*;


@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cityId;

    private String cityName;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private States state;

    // Getters and Setters
}


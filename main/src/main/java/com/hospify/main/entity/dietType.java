package com.hospify.main.entity;

import jakarta.persistence.*;


@Entity
public class DietType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dietTypeId;

    private String dietType;

    // Getters and Setters
}

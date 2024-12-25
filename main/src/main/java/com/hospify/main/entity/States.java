package com.hospify.main.entity;

import jakarta.persistence.*;

@Entity
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stateId;

    private String stateName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}

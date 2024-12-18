package com.hospify.main.entity;

import jakarta.persistence.*;

@Entity
public class dietType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dietType_id")
    private long dietTypeId;
    private String dietType;

}

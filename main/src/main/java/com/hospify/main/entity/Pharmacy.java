package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_id")
    private long pharmacyId;
    private User user;
    private appointment appointment;
    private Doctor doctor;
    private Prescription prescription;
    private Hospital hospital;
    private Payment payment;
    private String status;
    private String pharmacySpecilization;

}

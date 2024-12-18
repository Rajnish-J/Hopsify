package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    private long prescriptionId;
    private Doctor doctor;
    private User user;
    private appointment appointment;
    private Medicine medicine;

}

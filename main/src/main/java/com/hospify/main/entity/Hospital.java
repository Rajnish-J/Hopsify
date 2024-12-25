package com.hospify.main.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.List;

//No Mapping for City , State ,Country...

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hospitalId;

    private String hospitalName;
    private String hospitalEmail;
    private String hospitalPassword;
    private long phoneNumber;
    private String city;
    private String street;
    private String state;
    private String country;
    private long pincode;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pharmacy> pharmacies;

    // Getters and Setters
}

package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private long hospitalId;
    private String hospitalName;
    private String phoneNumber;
    private String hospitalEmail;
    private String hospitalPassword;
    private List<appointment> appointments;
    private String streetName;
    private City city;
    private state state;
    private country country;
    private long pincode;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdateAt;
    private List<Doctor> doctorList;

}

package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

    @Column(nullable = false,unique = false)
    private String hospitalName;

    @Column(nullable = false,unique = false)
    private String phoneNumber;

    @Column(nullable = false,unique = false)
    private String hospitalEmail;

    @Column(nullable = false)
    private String hospitalPassword;

    @Column(nullable = false)
    private List<Doctor> doctorList;

    @Column(nullable = false)
    private List<appointment> appointments;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private City city;

    @Column(nullable = false)
    private state state;

    @Column(nullable = false)
    private country country;

    @Column(nullable = false)
    private long pincode;

    @CreatedDate
    private LocalDateTime CreatedAt;

    @LastModifiedDate
    private LocalDateTime UpdateAt;


}

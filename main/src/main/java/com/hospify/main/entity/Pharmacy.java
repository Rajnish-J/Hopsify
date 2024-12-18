package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_id")
    private long pharmacyId;

    @Column(nullable = false)
    private User user;

    @Column(nullable = false)
    private appointment appointment;

    @Column(nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private Prescription prescription;

    @Column(nullable = false)
    private Hospital hospital;

    @Column(nullable = false)
    private Payment payment;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String pharmacySpecilization;

    @CreatedDate
    private LocalDateTime CreatedAt;

    @LastModifiedDate
    private LocalDateTime UpdateAt;

}

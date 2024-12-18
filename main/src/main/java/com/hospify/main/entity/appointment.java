package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private long appointmentId;
    private LocalDate appointmentDate;
    private String reason;
    private String appointmentStatus;
    private User user;
    private Hospital hospital;
    private Doctor doctor;
    private Payment payment;
    private Prescription prescription;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdateAt;
}

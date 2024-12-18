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
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private long doctorId;
    private String doctorName;
    private Hospital hospital;
    private long phoneNumber;
    private String email;
    private String password;
    private String gender;
    private String specilization;
    private List<appointment> appointmentList;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdateAt;

}

package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    private String userName;
    private String  userContactNo;
    private String userEmail;
    private String userPassword;
    private LocalDate dateOfBirth;
    private String Gender;
    private int height;
    private int weight;
    private List<appointment> appointments;
    private String streetName;
    private City city;
    private state state;
    private country country;
    private long pincode;
    private dietType diet;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdateAt;
}

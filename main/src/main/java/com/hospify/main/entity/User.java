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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String  userContactNo;
    private String Gender;
    private LocalDate dateOfBirth;
    private int height;
    private int weight;
    private String streetname;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdateAt;
}

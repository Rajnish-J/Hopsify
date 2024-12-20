package com.hospify.main.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false,unique = true)
    private String  userContactNo;

    @Column(nullable = false,unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String Gender;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int weight;

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

    //@Column(nullable = false)
    private dietType diet;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime CreatedAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime UpdateAt;
    //Getter And Setter

}

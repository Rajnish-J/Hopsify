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
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private long paymentId;
    private User user;
    private Amount amount;
    private LocalDate paymentDate;
    private String paymentType;
    private String paymentStatus;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdateAt;

}

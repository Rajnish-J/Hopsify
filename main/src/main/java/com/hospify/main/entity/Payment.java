package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

    @Column(nullable = false)
    private User user;

    @Column(nullable = false)
    private Amount amount;

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Column(nullable = false)
    private String paymentType;

    @Column(nullable = false)
    private String paymentStatus;

    @CreatedDate
    private LocalDateTime CreatedAt;

    @LastModifiedDate
    private LocalDateTime UpdateAt;

}

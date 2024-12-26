package com.hospify.main.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foodId;

    @Column(nullable = false)
    private String foodName;

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false)
    private double carbohydrates;

    @Column(nullable = false)
    private double proteins;

    @Column(nullable = false)
    private double calories;

    @Column(nullable = false)
    private double vitamins;

    @Column(nullable = false)
    private double fat;
}

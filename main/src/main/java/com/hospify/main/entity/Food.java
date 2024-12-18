package com.hospify.main.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private long foodId;
    
    @Column(unique = false, nullable = false)
    private String foodName;
    
    @Column(unique = false, nullable = false)
    private int quantity;
    
    @Column(unique = false, nullable = false)
    private int carbohydrates;
    
    @Column(unique = false, nullable = false)
    private int proteins;
    
    @Column(unique = false, nullable = false)
    private int calories;
    
    @Column(unique = false, nullable = false)
    private int vitamins;
    
    @Column(unique = false, nullable = false)
    private int fat;

    @CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false)
    private LocalDateTime CreatedAt;
    
    @LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt", nullable = false)
    private LocalDateTime UpdateAt;

}

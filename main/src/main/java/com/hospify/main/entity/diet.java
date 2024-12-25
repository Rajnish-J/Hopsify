package com.hospify.main.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dietId;

    @ManyToOne
    @JoinColumn(name = "diet_type_id")
    private DietType dietType;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    // Getters and Setters

}

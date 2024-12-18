package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private long foodId;
    private String foodName;
    private int quantity;
    private int carbohydrates;
    private int proteins;
    private int calories;
    private int vitamins;
    private int fat;

}

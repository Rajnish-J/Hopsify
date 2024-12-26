package com.hospify.main.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
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

    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getVitamins() {
        return vitamins;
    }

    public void setVitamins(double vitamins) {
        this.vitamins = vitamins;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", quantity=" + quantity +
                ", carbohydrates=" + carbohydrates +
                ", proteins=" + proteins +
                ", calories=" + calories +
                ", vitamins=" + vitamins +
                ", fat=" + fat +
                '}';
    }
}

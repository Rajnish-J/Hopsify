package com.hospify.main.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
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

    //Getter And Setter


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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getVitamins() {
        return vitamins;
    }

    public void setVitamins(int vitamins) {
        this.vitamins = vitamins;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        UpdateAt = updateAt;
    }

    //ToString

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
                ", CreatedAt=" + CreatedAt +
                ", UpdateAt=" + UpdateAt +
                '}';
    }
}

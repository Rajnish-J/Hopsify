package com.hospify.main.entity;

import jakarta.persistence.*;

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

    public long getDietId() {
        return dietId;
    }

    public void setDietId(long dietId) {
        this.dietId = dietId;
    }

    public DietType getDietType() {
        return dietType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Diet{" +
                "dietId=" + dietId +
                ", dietType=" + dietType +
                ", food=" + food +
                '}';
    }
}

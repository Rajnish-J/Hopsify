package com.hospify.main.entity;

import jakarta.persistence.*;

@Entity
public class DietType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dietTypeId;

    private String dietType;

    public long getDietTypeId() {
        return dietTypeId;
    }

    public void setDietTypeId(long dietTypeId) {
        this.dietTypeId = dietTypeId;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    @Override
    public String toString() {
        return "DietType{" +
                "dietTypeId=" + dietTypeId +
                ", dietType='" + dietType + '\'' +
                '}';
    }
}

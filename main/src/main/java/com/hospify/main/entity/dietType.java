package com.hospify.main.entity;

import jakarta.persistence.*;


@Entity
public class dietType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dietType_id")
    private long dietTypeId;
    
    @Column(unique = false, nullable = false)
    private String dietType;

    //Getter And Setter

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

    //ToString

    @Override
    public String toString() {
        return "dietType{" +
                "dietTypeId=" + dietTypeId +
                ", dietType='" + dietType + '\'' +
                '}';
    }
}

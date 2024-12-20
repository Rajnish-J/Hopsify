package com.hospify.main.entity;

import jakarta.persistence.*;
@Entity
public class country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private long countryId;
    
    @Column(unique = false, nullable = false)
    private String countryName;

    //Getter And Setter
    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    //ToString

    @Override
    public String toString() {
        return "country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}

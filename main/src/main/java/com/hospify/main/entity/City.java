package com.hospify.main.entity;

import jakarta.persistence.*;


@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private long cityId;
    
    @Column(unique = false, nullable = false)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "stateId", referencedColumnName = "stateId")
    private state state;



    //Getter And Setter

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public com.hospify.main.entity.state getState() {
        return state;
    }

    public void setState(com.hospify.main.entity.state state) {
        this.state = state;
    }

    //ToString

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", state=" + state +
                '}';
    }
}


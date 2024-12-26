package com.hospify.main.entity;

import jakarta.persistence.*;

@Entity
public class States {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stateId;

    @Column(nullable = false)
    private String stateName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "States{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                ", country=" + country +
                '}';
    }
}

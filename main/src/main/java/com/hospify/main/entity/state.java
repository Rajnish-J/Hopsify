package com.hospify.main.entity;

import jakarta.persistence.*;

@Entity
public class state {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private long stateId;

    @Column(nullable = false)
    private String stateName;

    @Column(nullable = false)
    private country country;

    //Getter And Setter

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

    public com.hospify.main.entity.country getCountry() {
        return country;
    }

    public void setCountry(com.hospify.main.entity.country country) {
        this.country = country;
    }

    //ToString

    @Override
    public String toString() {
        return "state{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                ", country=" + country +
                '}';
    }
}

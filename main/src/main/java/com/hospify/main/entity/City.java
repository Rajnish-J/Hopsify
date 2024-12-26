package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
public class City {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cityId;

    private String cityName;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private States state;
}


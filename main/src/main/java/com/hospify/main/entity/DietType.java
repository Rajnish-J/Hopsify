package com.hospify.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
public class DietType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dietTypeId;

    private String dietType;
}
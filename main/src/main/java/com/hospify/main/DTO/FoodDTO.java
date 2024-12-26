package com.hospify.main.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class FoodDTO {

    private long foodId;

    private String foodName;

    private double quantity;

    private double carbohydrates;

    private double proteins;

    private double calories;

    private double vitamins;

    private double fat;

}

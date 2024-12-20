package com.hospify.main.Repo;

import com.hospify.main.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long> {
}

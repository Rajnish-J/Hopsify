package com.hospify.main.Repo;

import com.hospify.main.entity.diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepo extends JpaRepository<diet, Long> {
}

package com.hospify.main.Repo;

import com.hospify.main.entity.DietType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietTypeRepo extends JpaRepository<DietType, Long> {
}

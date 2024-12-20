package com.hospify.main.Repo;

import com.hospify.main.entity.dietType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietTypeRepo extends JpaRepository<dietType, Long> {
}

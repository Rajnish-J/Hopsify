package com.hospify.main.Repo;

import com.hospify.main.entity.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepo extends JpaRepository<Diet, Long> {
}

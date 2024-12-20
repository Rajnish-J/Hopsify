package com.hospify.main.Repo;

import com.hospify.main.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine, Long> {
}

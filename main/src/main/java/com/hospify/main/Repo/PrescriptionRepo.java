package com.hospify.main.Repo;

import com.hospify.main.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {

   public List<Prescription> findByPharmacyPharmacyId(long pharmacyId);
}

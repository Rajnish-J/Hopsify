package com.hospify.main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospify.main.entity.Pharmacy;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Long>{

    List<Pharmacy> findByHospitalHospitalId(long hospitalId);
}

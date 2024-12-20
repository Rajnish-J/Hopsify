package com.hospify.main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospify.main.entity.Pharmacy;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Long>{
    
}

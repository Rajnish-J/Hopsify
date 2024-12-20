package com.hospify.main.Repo;

import com.hospify.main.entity.country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<country, Long> {
}

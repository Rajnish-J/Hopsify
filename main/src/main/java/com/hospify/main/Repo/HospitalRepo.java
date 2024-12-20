package com.hospify.main.Repo;

import com.hospify.main.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepo extends JpaRepository<Hospital, Long> {
}

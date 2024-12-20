package com.hospify.main.Repo;

import com.hospify.main.entity.appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<appointment, Long> {
}

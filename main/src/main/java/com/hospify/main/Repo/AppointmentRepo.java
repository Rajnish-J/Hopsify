package com.hospify.main.Repo;

import com.hospify.main.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    //Find All Appointment Based on Status.
   public List<Appointment> findByAppointmentStatus(String status);

   //Filter By Dates
    @Query("SELECT a FROM Appointment a WHERE DATE(a.appointmentDate) BETWEEN :startDate AND :endDate")
    List<Appointment> findAppointmentsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}

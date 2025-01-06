package com.hospify.main.Repo;

import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    // Query to check if a doctor with the given email exists
    @Query("SELECT COUNT(d) > 0 FROM Doctor d WHERE d.email = :email")
    boolean existsByEmail(@Param("email") String email);

    // Query to check if a doctor with the given phone number exists
    @Query("SELECT COUNT(d) > 0 FROM Doctor d WHERE d.doctorPhone = :phone")
    boolean existsByPhone(@Param("phone") Long phone);

    // checking custom query for that incoming user id that first exists in the database:
    boolean existsById(Long doctorId);

    // fetch all appointments respect to the doctor ID
    @Query("SELECT a FROM Appointment a WHERE a.doctor.doctorId = :doctorId")
    List<Appointment> findAllAppointments(@Param("doctorId") Long doctorId);


}

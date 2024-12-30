package com.hospify.main.Repo;

import com.hospify.main.entity.Appointment;
import com.hospify.main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    // validate Email
    List<User> findByUserEmail(String email);

    //Validate Contact Number
    List<User> findByUserContactNo(long userContactNo);

    // view all appointments
    @Query("SELECT a from Appointment a WHERE a.user.userId = :userId")
    List<Appointment> findAllAppointments(@Param("userId") long userId);

    // checking custom query for that incoming user id that first exists in the database:
    @Query("SELECT u.userId AS userId FROM User u")
    List<Long> fetchAllPatientId();
}

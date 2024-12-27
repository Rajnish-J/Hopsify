package com.hospify.main.Repo;

import com.hospify.main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByUserEmail(String email);
    List<User> findByUserContactNo(long userContactNo);
}

package com.hospify.main.Repo;

import com.hospify.main.entity.States;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepo extends JpaRepository<States, Long> {
}

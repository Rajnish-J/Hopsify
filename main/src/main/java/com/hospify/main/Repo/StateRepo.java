package com.hospify.main.Repo;

import com.hospify.main.entity.state;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepo extends JpaRepository<state, Long> {
}

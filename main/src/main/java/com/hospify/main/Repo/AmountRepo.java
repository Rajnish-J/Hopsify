package com.hospify.main.Repo;

import com.hospify.main.entity.Amount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmountRepo extends JpaRepository<Amount, Long> {
}

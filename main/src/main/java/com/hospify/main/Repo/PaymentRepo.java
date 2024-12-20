package com.hospify.main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospify.main.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
}

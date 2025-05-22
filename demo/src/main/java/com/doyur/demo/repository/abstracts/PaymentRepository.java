package com.doyur.demo.repository.abstracts;

import com.doyur.demo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Optional<Payment> findByPaymentName(String paymentName);
}

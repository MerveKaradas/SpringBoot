package com.doyur.demo.service.abstracts;

import com.doyur.demo.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();

    Payment findPaymentById(int id);

    Payment savePayment(Payment payment);

    Payment updatePayment(int id, Payment payment);

    void deletePayment(int id);
}

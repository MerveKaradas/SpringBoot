package com.doyur.demo.service.concretes;

import com.doyur.demo.model.Payment;
import com.doyur.demo.repository.abstracts.PaymentRepository;
import com.doyur.demo.service.abstracts.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceManager implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceManager(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findPaymentById(int id) {
        return paymentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Payment not found"));
    }

    @Override
    public Payment savePayment(Payment payment) {
        Optional<Payment> paymentOptional = paymentRepository.findByPaymentName(payment.getPaymentName());
        if (paymentOptional.isPresent()) {
            throw new IllegalArgumentException("Payment already exists");
        }
        return paymentRepository.save(payment);

    }

    @Override
    public Payment updatePayment(int id, Payment payment) {
        Payment paymentToUpdate = paymentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Payment not found"));

        paymentToUpdate.setPaymentName(payment.getPaymentName());
        paymentToUpdate.setAmount(payment.getAmount());
        paymentToUpdate.setPaymentDate(payment.getPaymentDate());
        paymentToUpdate.setOrder(payment.getOrder());


        return paymentRepository.save(paymentToUpdate);
    }

    @Override
    public void deletePayment(int id) {
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        if (paymentOptional.isPresent()) {
            paymentRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("Payment not found");
        }
    }
}

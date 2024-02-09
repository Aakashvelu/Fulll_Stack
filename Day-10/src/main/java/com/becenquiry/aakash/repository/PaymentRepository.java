package com.becenquiry.aakash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becenquiry.aakash.model.Payment;
import com.becenquiry.aakash.model.User;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    List<Payment> findAll();

    // void save(Payment payment);

    // boolean existsById(String paymentId);

    // void deleteById(String paymentId);

}

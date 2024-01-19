package com.mn.springbootsampler.model.repositories;

import com.mn.springbootsampler.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment in);

    Optional<Payment> findById(Integer id);

    List<Payment> findById();
}

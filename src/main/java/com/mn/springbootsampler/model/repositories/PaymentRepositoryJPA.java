package com.mn.springbootsampler.model.repositories;

import com.mn.springbootsampler.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PaymentRepositoryJPA extends JpaRepository<Payment, Integer> {
}

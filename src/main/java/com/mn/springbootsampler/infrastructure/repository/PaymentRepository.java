package com.mn.springbootsampler.infrastructure.repository;

import com.mn.springbootsampler.model.Payment;
import com.mn.springbootsampler.model.repositories.GenericRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class PaymentRepository implements GenericRepository<Payment, Integer> {
    private final JpaRepository<Payment, Integer> innerRepos;

    @Override
    public JpaRepository<Payment, Integer> provide() {
        return innerRepos;
    }
}

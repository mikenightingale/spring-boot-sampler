package com.mn.springbootsampler.infrastructure.repository;

import com.mn.springbootsampler.model.Payment;
import com.mn.springbootsampler.model.repositories.GenericRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class PaymentRepository implements GenericRepository<Payment, Integer> {
    private final JpaRepository<Payment, Integer> innerRepos;

    @Override
    public Payment save(Payment in) {
        return innerRepos.save(in);
    }

    @Override
    public Optional<Payment> findById(Integer id) {
        return innerRepos.findById(id);
    }

    @Override
    public List<Payment> findById() {
        return innerRepos.findAll();
    }
}

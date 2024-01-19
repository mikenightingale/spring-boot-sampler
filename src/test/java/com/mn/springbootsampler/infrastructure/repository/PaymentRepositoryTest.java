package com.mn.springbootsampler.infrastructure.repository;

import com.mn.springbootsampler.model.Payment;
import com.mn.springbootsampler.model.repositories.GenericRepository;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mn.springbootsampler.TestHelpers.providePayment;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureEmbeddedDatabase( refresh = AutoConfigureEmbeddedDatabase.RefreshMode.AFTER_EACH_TEST_METHOD)
class PaymentRepositoryTest {
    @Autowired
    GenericRepository<Payment, Integer> genericRepository;

    @Test
    void shouldSavePayment() {
        Payment p = providePayment();
        var result = genericRepository.save(p);
        assertThat(result.getId()).isGreaterThanOrEqualTo(1);
        assertThat(result.toString()).endsWith(" bic=DE1234567, iban=DE123456789123, currency=EUR, amount=99)");
    }

    @Test
    void shouldReadBackPaymentById() {
        var save = genericRepository.save(providePayment());
        var byId = genericRepository.findById(save.getId());
        assertThat(byId).isPresent();
        assertThat(byId).hasValueSatisfying(s -> {
            assertThat(s.toString()).isEqualTo("Payment(id=1, bic=DE1234567, iban=DE123456789123, currency=EUR, amount=99)");
        });
    }

    @Test
    void shouldReadBackAllPayment() {
        genericRepository.save(providePayment());
        genericRepository.save(providePayment());
        var result = genericRepository.findAll();
        assertThat(result).hasSize(2);

    }
}
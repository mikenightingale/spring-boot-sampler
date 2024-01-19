package com.mn.springbootsampler.infrastructure.repository;

import com.mn.springbootsampler.model.Payment;
import com.mn.springbootsampler.model.repositories.PaymentRepository;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mn.springbootsampler.TestHelpers.providePayment;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureEmbeddedDatabase( refresh = AutoConfigureEmbeddedDatabase.RefreshMode.AFTER_EACH_TEST_METHOD)
class PaymentRepositoryImplTest {
    @Autowired
    PaymentRepository paymentRepository;

    @Test
    void shouldSavePayment() {
        Payment p = providePayment();
        var result = paymentRepository.save(p);
        assertThat(result.getPaymentId()).isGreaterThanOrEqualTo(1);
        assertThat(result.toString()).endsWith(" bic=DE1234567, iban=DE123456789123, currency=EUR, amount=99)");
    }

    @Test
    void shouldReadBackPaymentById() {
        var save = paymentRepository.save(providePayment());
        var byId = paymentRepository.findById(save.getPaymentId());
        assertThat(byId).isPresent();
        assertThat(byId).hasValueSatisfying(s -> {
            assertThat(s.toString()).isEqualTo("Payment(paymentId=1, bic=DE1234567, iban=DE123456789123, currency=EUR, amount=99)");
        });
    }

    @Test
    void shouldReadBackAllPayment() {
        paymentRepository.save(providePayment());
        paymentRepository.save(providePayment());
        var result = paymentRepository.findById();
        assertThat(result).hasSize(2);

    }
}
package com.mn.springbootsampler.model;

import org.junit.jupiter.api.Test;

import static com.mn.springbootsampler.TestHelpers.providePayment;
import static org.assertj.core.api.Assertions.assertThat;


class PaymentTest {
    @Test
    void shouldBuildPayment() {
        Payment p = providePayment();
        assertThat(p.toString()).isEqualTo("Payment(paymentId=null, bic=DE1234567, iban=DE123456789123, currency=EUR, amount=99)");
    }
}
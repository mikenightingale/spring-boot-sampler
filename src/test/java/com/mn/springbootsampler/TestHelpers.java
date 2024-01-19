package com.mn.springbootsampler;

import com.mn.springbootsampler.model.Payment;

public class TestHelpers {
     public static Payment providePayment() {
        return Payment.builder()
                .iban("DE123456789123")
                .bic("DE1234567")
                .currency("EUR")
                .amount(99)
                .build();
     }
}

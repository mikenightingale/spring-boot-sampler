package com.mn.springbootsampler;

import com.mn.springbootsampler.model.Event;
import com.mn.springbootsampler.model.Payment;

import java.util.UUID;

public class TestHelpers {

    public static final String EVENT = """
            {
            	"bic"  : "DE0000001",
            	"iban" : "DE123456789023",
            	"currency" : "EUR",
            	"amount": 9
            }
            """;

    public static Payment providePayment() {
        return Payment.builder()
                .iban("DE123456789123")
                .bic("DE1234567")
                .currency("EUR")
                .amount(99)
                .build();
     }

    public static Event provideEvent() {
        return Event.builder()
                .body(EVENT)
                .publicId(UUID.randomUUID())
                .build();
    }
}

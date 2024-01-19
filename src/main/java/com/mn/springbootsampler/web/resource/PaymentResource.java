package com.mn.springbootsampler.web.resource;

public record PaymentResource(String bic, String iban, String currency, int amount) {
}

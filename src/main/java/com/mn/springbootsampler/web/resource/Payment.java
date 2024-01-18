package com.mn.springbootsampler.web.resource;

public record Payment(String bic, String iban, String currency, int amount) {
}

package com.mn.springbootsampler.web;


import com.mn.springbootsampler.infrastructure.PaymentProducer;
import com.mn.springbootsampler.web.resource.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/payment", consumes = "application/json")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentProducer producer;

    @PostMapping("/string")
    @Async
    public CompletableFuture<String> publishMessage(@RequestBody Payment payment)  {

        var send = producer.send(payment.iban(), payment.toString());
        return send;
    }
}

package com.mn.springbootsampler.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer2 {

    @KafkaListener(topics = "payment", groupId = "parallel2" )
    public void consume(String message)
    {
        System.out.println("Received2 = " + message);
    }
}

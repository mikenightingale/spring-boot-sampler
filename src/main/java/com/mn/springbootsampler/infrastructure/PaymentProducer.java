package com.mn.springbootsampler.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class PaymentProducer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "payment";

    @Async
    public CompletableFuture<String> send(String key, String msg )  {

        return kafkaTemplate.send(TOPIC, key, msg)
                .handle(PaymentProducer::handle);
    }

    private static String handle(SendResult<String, String> r, Throwable x)  {
        if (x != null){
            throw new RuntimeException(x.getMessage());
        }

        return  r.getRecordMetadata().toString();
    }

}

package com.mn.springbootsampler.infrastructure;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Disabled
class PaymentResourceProducerTest {

    private static final String TOPIC = "payment";
    public static final String TEST_MSG = """
            {
            	"bic"  : "DE0000001",
            	"iban" : "DE123456789023",
            	"currency" : "EUR",
            	"amount": 100
            }
            """;
    public static final String TEST_KEY = "DE123456789023";
    @Mock
    KafkaTemplate<String, String> mockKafkaTemplate;
    @InjectMocks
    private PaymentProducer subject;

    @Test
    void should() throws ExecutionException, InterruptedException {
        var success = new CompletableFuture<SendResult<String, String>>();
        var value = new SendResult<String, String>(null, mock(RecordMetadata.class));
        success.complete(value);
        when(mockKafkaTemplate.send(TOPIC, TEST_KEY, TEST_MSG)).thenReturn(success);

        var future = subject.send(TEST_KEY, TEST_MSG);
        assertThat(future).isCompleted();
    }

    @Test
    void shouldReportError() throws ExecutionException, InterruptedException {

        var exceptional = new CompletableFuture<SendResult<String, String>>();
        exceptional.completeExceptionally(new RuntimeException("Failed"));
        when(mockKafkaTemplate.send(TOPIC, TEST_KEY, TEST_MSG)).thenReturn(exceptional);

        var future = subject.send(TEST_KEY, TEST_MSG);


        var result = assertThrows(ExecutionException.class, () -> future.get())  ;
        assertThat(result.getCause().getMessage()).isEqualTo("Failed");
    }
}
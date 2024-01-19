package com.mn.springbootsampler.infrastructure;

import com.mn.springbootsampler.infrastructure.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersistenceConsumer {

    private final EventRepository genericRepository;

    @KafkaListener( groupId = "parallel1" , topicPartitions = {
            @TopicPartition(topic = "payment", partitionOffsets = @PartitionOffset(partition = "1",initialOffset = "0"))
    })
    public void consumeAll(String message)
    {
        System.out.println("History = " + message);
    }

    @KafkaListener(topics = "payment", groupId = "parallel1" )
    public void consume(String message)
    {
        System.out.println("Received1 = " + message);
    }
}
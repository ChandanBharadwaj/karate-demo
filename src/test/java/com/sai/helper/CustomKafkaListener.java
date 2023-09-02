package com.sai.helper;

import org.apache.kafka.clients.consumer.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class CustomKafkaListener {

    private final KafkaConsumer<String, String> consumer;
    private final List<String> receivedEvents = new ArrayList<>();

    public CustomKafkaListener() {
        Properties props = new Properties();
        // Configure Kafka consumer properties here

        consumer = new KafkaConsumer<>(props);
    }

    public void startListening(String topic) {
        consumer.subscribe(Collections.singletonList(topic));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));
            for (ConsumerRecord<String, String> record : records) {
                String event = record.value();
                receivedEvents.add(event); // Store received event
                // You can add more processing here if needed
            }
        }
    }

    public List<String> getReceivedEvents() {
        return receivedEvents;
    }

    public void close() {
        consumer.close();
    }
}

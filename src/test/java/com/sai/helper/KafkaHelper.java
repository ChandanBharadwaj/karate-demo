package com.sai.helper;

public class KafkaHelper {

    private CustomKafkaProducer kafkaProducer;
    private CustomKafkaListener kafkaListener;

    public KafkaHelper() {
        kafkaProducer = new CustomKafkaProducer();
        kafkaListener = new CustomKafkaListener();
    }

    public void sendKafkaMessage(String topic, String message) {
        kafkaProducer.sendMessage(topic, message);
    }

    public void startListeningToKafka(String topic) {
        kafkaListener.startListening(topic);
    }

    public void closeKafkaComponents() {
        kafkaProducer.close();
        kafkaListener.close();
    }
}

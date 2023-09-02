Feature: Kafka Helper

Background:
  * def kafkaHelper = new KafkaHelper()

Scenario: Start Kafka Listener
  * def topic = karate.get('topic')
  * call kafkaHelper.startListening(topic)

Scenario: Get Received Events
  * def receivedEvents = karate.call(kafkaHelper.getReceivedEvents())

Scenario: Stop Kafka Listener
  * call kafkaHelper.closeKafkaListener()

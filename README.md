# Kafka test producer

This is a simple implementation of a kafka producer.

## How to run

First you will need a running kafka instance. The one from [spotify](https://github.com/JonasJurczok/docker-kafka) is recommended.

If you have the kafka "cluster" up and running just issue a ``mvn clean verify && java -cp target/producertest-1-jar-with-dependencies.jar de.zalando.kafka.producertest.Main``.

Depending on how you have set up your kafka cluster you might need to change the properties in the beginning of the Main class.

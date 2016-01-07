package de.zalando.kafka.producertest;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Logger logger = LoggerFactory.getLogger(Main.class);

        Properties config = new Properties();
        config.put("bootstrap.servers", "localhost:9092");
        config.put("acks", "all");
        config.put("retries", 0);
        config.put("batch.size", 16384);
        config.put("linger.ms", 1);
        config.put("buffer.memory", 33554432);
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(config);

        try {
            int currentKey = 0;
            int currentValue = 0;

            while (true) {
                currentKey++;
                currentValue++;
                String key = "key" + currentKey % 5;
                String value = "Samplevalue" + currentValue;

                producer.send(new ProducerRecord<String, String>("main", key, value));

                logger.info("Sent key [{}] with value [{}].", key, value);

                Thread.sleep(5000);
            }
        } finally {
            producer.close();
        }

    }
}

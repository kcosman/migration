package com.nfl.mysqltoneo.config;

import com.nfl.dm.shield.ingestion.kafka.producer.MessageProducer;
import com.nfl.dm.shield.ingestion.kafka.producer.MessageProducerImpl;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.kafka.support.ProducerMetadata;

import java.util.Properties;

@Configuration
public class KafkaProducerConfig {
    @Value("${kafka.connection.url}")
    private String kafkaConnectionUrl;

    @Value("${request.required.acks}")
    private String requestAcknowledgement;

    @Value("${kafka.job.topic}")
    private String kafkaJobTopic;

    @Bean(name = "videoMessageProducer")
    public MessageProducer<String> createVideoMessageProducer() throws Exception {
        ProducerMetadata<String, String> metadata = new ProducerMetadata<>(
                kafkaJobTopic,
                String.class,
                String.class,
                new StringSerializer(),
                new StringSerializer());
        return new MessageProducerImpl<>(kafkaConnectionUrl, metadata, producerProperties());
    }

    private Properties producerProperties() {
        Properties properties = new Properties();
       // properties.put("request.required.acks", requestAcknowledgement);
        return properties;
    }
}

package br.com.caelum.garagesharing.infra.kafka.core;

import java.util.Map;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaPublisherFactory {

    private final Map<String, Object> producerProperties;

    KafkaPublisherFactory(KafkaProperties kafkaProperties) {
        producerProperties = kafkaProperties.buildProducerProperties();
    }

    public <K, V, E extends Enum<E> & NameableTopic> KafkaPublisher<K, V> createPublisherFor(E topic) {

        DefaultKafkaProducerFactory<K, V> producerFactory = new DefaultKafkaProducerFactory<>(producerProperties);

        KafkaTemplate<K, V> template = new KafkaTemplate<>(producerFactory);

        return new KafkaPublisher<>(template, topic);
    }
}

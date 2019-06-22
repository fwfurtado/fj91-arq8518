package br.com.caelum.garagesharing.kafka;

import java.util.Map;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaPublisherFactory {

    private final Map<String, Object> producerProperties;

    public KafkaPublisherFactory(KafkaProperties properties) {
        this.producerProperties = properties.buildProducerProperties();
    }

    public <K,V, E extends Enum<E> & TopicNameable> KafkaPublisher<K,V> factory(E topic) {

        DefaultKafkaProducerFactory<K, V> producerFactory = new DefaultKafkaProducerFactory<>(producerProperties);

        KafkaTemplate<K, V> template = new KafkaTemplate<>(producerFactory);

        return new KafkaPublisher<K, V>(template, topic);
    }
}

package br.com.caelum.garagesharing.infra.kafka.core;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.util.concurrent.ListenableFuture;

public class KafkaPublisher<K, V> {

    private final KafkaTemplate<K, V> template;
    private final String topic;

    KafkaPublisher(KafkaTemplate<K, V> template, NameableTopic topic) {
        this.template = template;
        this.topic = topic.name();

        ensureDefaultTopic();
    }

    private void ensureDefaultTopic() {
        template.setDefaultTopic(topic);
    }

    public ListenableFuture<SendResult<K, V>> send(V data) {
        return template.send(topic, data);
    }

    public ListenableFuture<SendResult<K, V>> send(K key, V data) {
        return template.send(topic, key, data);
    }

    public ListenableFuture<SendResult<K, V>> send(Integer partition, K key, V data) {
        return template.send(topic, partition, key, data);
    }

    public ListenableFuture<SendResult<K, V>> send(Integer partition, Long timestamp, K key, V data) {
        return template.send(topic, partition, timestamp, key, data);
    }

    public ListenableFuture<SendResult<K, V>> send(Message<?> message) {
        return template.send(message);
    }
}

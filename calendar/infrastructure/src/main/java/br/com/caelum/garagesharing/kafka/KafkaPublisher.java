package br.com.caelum.garagesharing.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

public class KafkaPublisher<K,V> {

    private final KafkaTemplate<K, V> template;
    private final String topic;

    <E extends Enum<E> & TopicNameable> KafkaPublisher(KafkaTemplate<K,V> template, E topic) {
        this.template = template;
        this.topic = topic.getTopicName();
    }

    public ListenableFuture<SendResult<K, V>> send(V value) {
        return template.send(topic, value);
    }


}

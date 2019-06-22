package br.com.caelum.garagesharing.calendar.shared.configuration;

import br.com.caelum.garagesharing.kafka.KafkaPublisher;
import br.com.caelum.garagesharing.kafka.KafkaPublisherFactory;
import br.com.caelum.garagesharing.kafka.TopicNameable;
import br.com.caelum.garasesharing.event.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
class KafkaConfiguration {

    @Bean
    KafkaPublisher<String, Event> publisher(KafkaPublisherFactory publisherFactory) {
        return publisherFactory.factory(OwnTopics.CALENDARS);
    }


    enum OwnTopics implements TopicNameable {
        CALENDARS
    }
}

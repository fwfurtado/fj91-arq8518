package br.com.caelum.garagesharing.calendar.shared.configuration;

import br.com.caelum.garagesharing.kafka.KafkaPublisher;
import br.com.caelum.garagesharing.kafka.KafkaPublisherFactory;
import br.com.caelum.garagesharing.kafka.NameableTopic;
import br.com.caelum.garasesharing.event.Event;
import java.util.EnumSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
class KafkaConfiguration {

    @Bean
    KafkaPublisher<String, Event> publisher(KafkaPublisherFactory publisherFactory) {
        return publisherFactory.factory(KafkaTopics.CALENDARS);
    }
}

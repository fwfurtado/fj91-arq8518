package br.com.caelum.garagesharing.calendar.listeners.calendar;

import br.com.caelum.garagesharing.infra.kafka.core.KafkaPublisher;
import br.com.caelum.garasesharing.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class CalendarLocalListener {

    private final Logger LOG = LoggerFactory.getLogger(CalendarLocalListener.class);
    private final KafkaPublisher<String, Event> publisher;

    CalendarLocalListener(KafkaPublisher<String, Event> publisher) {
        this.publisher = publisher;
    }

    @EventListener
    void sendToKafka(Event event) {
        LOG.info("[KAFKA] Send event to kafka: {}", event);

        publisher.send(event);
    }

}

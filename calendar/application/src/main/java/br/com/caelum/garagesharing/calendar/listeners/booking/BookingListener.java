package br.com.caelum.garagesharing.calendar.listeners.booking;

import br.com.caelum.garasesharing.event.Event;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
class BookingListener {

    private final ChangeCalendarService service;

    BookingListener(ChangeCalendarService service) {
        this.service = service;
    }

    @SendTo("${application.topics.calendar}")
    @KafkaListener(topics = "${application.topics.booking}")
    Event handle(BookingChangeStatusEvent event) {
        return service.onChangeCalendarBy(event);
    }
}

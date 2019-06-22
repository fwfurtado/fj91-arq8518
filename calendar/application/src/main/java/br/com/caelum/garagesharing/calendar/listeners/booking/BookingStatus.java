package br.com.caelum.garagesharing.calendar.listeners.booking;

import br.com.caelum.garasesharing.event.CreatedUnavailabilityEvent;
import java.time.LocalDateTime;
import java.util.function.BiFunction;

public enum BookingStatus {
    CREATED,
    PAYED,
    CHECKING, //TODO: change to started
    CHECKOUT, //TODO: change to finished
    CANCELLED;

}

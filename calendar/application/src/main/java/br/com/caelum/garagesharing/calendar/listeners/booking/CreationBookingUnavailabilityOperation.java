package br.com.caelum.garagesharing.calendar.listeners.booking;

import br.com.caelum.garasesharing.event.Event;

public interface CreationBookingUnavailabilityOperation extends ChangedBookingStatusOperation {

    Event createUnavailabilityBy(BookingChangeStatusEvent event);
}

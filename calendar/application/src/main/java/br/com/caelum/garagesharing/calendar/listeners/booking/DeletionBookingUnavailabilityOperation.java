package br.com.caelum.garagesharing.calendar.listeners.booking;

import br.com.caelum.garasesharing.event.Event;

public interface DeletionBookingUnavailabilityOperation extends ChangedBookingStatusOperation {

    Event deleteUnavailabilityBy(BookingChangeStatusEvent event);
}

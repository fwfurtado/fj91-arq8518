package br.com.caelum.garagesharing.calendar.listeners.booking.deletion;

import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;
import br.com.caelum.garasesharing.event.DeletedUnavailabilityEvent;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class BookingChangeStatusEventToDeletedUnavailabilityEventConverter implements Converter<Unavailability, DeletedUnavailabilityEvent> {

    @Override
    public DeletedUnavailabilityEvent convert(Unavailability source) {
        Garage garage = source.getGarage();
        return new DeletedUnavailabilityEvent(garage.getId(), source.getStart(), source.getEnd());
    }
}

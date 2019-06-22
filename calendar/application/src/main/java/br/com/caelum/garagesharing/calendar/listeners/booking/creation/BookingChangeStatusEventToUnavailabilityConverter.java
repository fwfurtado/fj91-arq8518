package br.com.caelum.garagesharing.calendar.listeners.booking.creation;

import br.com.caelum.garagesharing.calendar.listeners.booking.BookingChangeStatusEvent;
import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;
import br.com.caelum.garagesharing.calendar.shared.domain.UnavailabilityType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class BookingChangeStatusEventToUnavailabilityConverter implements Converter<BookingChangeStatusEvent, Unavailability> {

    @Override
    public Unavailability convert(BookingChangeStatusEvent source) {
        return new Unavailability(source.getStart(), source.getEnd(), UnavailabilityType.BOOKING, "Unavailable by booking");
    }
}

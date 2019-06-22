package br.com.caelum.garagesharing.calendar.listeners.booking.deletion;

import br.com.caelum.garagesharing.calendar.features.register.FindGarageRepository;
import br.com.caelum.garagesharing.calendar.listeners.booking.BookingChangeStatusEvent;
import br.com.caelum.garagesharing.calendar.listeners.booking.DeletionBookingUnavailabilityOperation;
import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;
import br.com.caelum.garagesharing.calendar.shared.exceptions.GarageNotFoundException;
import br.com.caelum.garagesharing.calendar.shared.exceptions.UnavailabilityNotFound;
import br.com.caelum.garasesharing.event.DeletedUnavailabilityEvent;
import br.com.caelum.garasesharing.event.Event;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class DeletionBookingUnavailabilityService implements DeletionBookingUnavailabilityOperation {

    private final FindGarageRepository garageRepository;
    private final DeletionUnavailabilityRepository unavailabilityRepository;
    private final Converter<Unavailability, DeletedUnavailabilityEvent> eventConverter;

    DeletionBookingUnavailabilityService(FindGarageRepository garageRepository, DeletionUnavailabilityRepository unavailabilityRepository,
        Converter<Unavailability, DeletedUnavailabilityEvent> eventConverter) {
        this.garageRepository = garageRepository;
        this.unavailabilityRepository = unavailabilityRepository;
        this.eventConverter = eventConverter;
    }

    @Override
    public Event deleteUnavailabilityBy(BookingChangeStatusEvent event) {
        String garageId = event.getGarageId();

        Garage garage = garageRepository.findById(garageId)
            .orElseThrow(() -> new GarageNotFoundException(garageId));

        Unavailability unavailability = unavailabilityRepository.findUnavailabilityByGarageAndStartAndEnd(garage, event.getStart(), event.getEnd())
                            .orElseThrow(() -> new UnavailabilityNotFound("Cannot find unavailability"));

        unavailabilityRepository.delete(unavailability);

        return eventConverter.convert(unavailability);
    }
}

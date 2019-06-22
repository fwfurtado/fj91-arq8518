package br.com.caelum.garagesharing.calendar.listeners.booking.creation;

import br.com.caelum.garagesharing.calendar.features.register.FindGarageRepository;
import br.com.caelum.garagesharing.calendar.features.register.RegisterUnavailabilityRepository;
import br.com.caelum.garagesharing.calendar.listeners.booking.BookingChangeStatusEvent;
import br.com.caelum.garagesharing.calendar.listeners.booking.ChangedBookingStatusOperation;
import br.com.caelum.garagesharing.calendar.listeners.booking.CreationBookingUnavailabilityOperation;
import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;
import br.com.caelum.garagesharing.calendar.shared.exceptions.GarageNotFoundException;
import br.com.caelum.garasesharing.event.CreatedUnavailabilityEvent;
import br.com.caelum.garasesharing.event.Event;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class CreationBookingUnavailabilityService implements CreationBookingUnavailabilityOperation  {

    private final FindGarageRepository garageRepository;
    private final RegisterUnavailabilityRepository registerRepository;
    private final Converter<BookingChangeStatusEvent, Unavailability> unavailabilityConverter;
    private final Converter<Unavailability, CreatedUnavailabilityEvent> eventConverter;

    CreationBookingUnavailabilityService(FindGarageRepository garageRepository, RegisterUnavailabilityRepository registerRepository,
        Converter<BookingChangeStatusEvent, Unavailability> unavailabilityConverter,
        Converter<Unavailability, CreatedUnavailabilityEvent> eventConverter) {
        this.garageRepository = garageRepository;
        this.registerRepository = registerRepository;
        this.unavailabilityConverter = unavailabilityConverter;
        this.eventConverter = eventConverter;
    }

    @Override
    public Event createUnavailabilityBy(BookingChangeStatusEvent event) {
        String garageId = event.getGarageId();

        Garage garage = garageRepository.findById(garageId)
                                .orElseThrow(() -> new GarageNotFoundException(garageId));

        Unavailability unavailability = unavailabilityConverter.convert(event);
        unavailability.setGarage(garage);

        registerRepository.save(unavailability);

        return eventConverter.convert(unavailability);
    }
}

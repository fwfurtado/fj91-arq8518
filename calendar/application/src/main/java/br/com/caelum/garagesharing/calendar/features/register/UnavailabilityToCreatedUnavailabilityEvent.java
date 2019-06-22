package br.com.caelum.garagesharing.calendar.features.register;

import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;
import br.com.caelum.garasesharing.event.CreatedUnavailabilityEvent;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class UnavailabilityToCreatedUnavailabilityEvent implements Converter<Unavailability, CreatedUnavailabilityEvent> {

    @Override
    public CreatedUnavailabilityEvent convert(Unavailability unavailability) {
        Garage garage = unavailability.getGarage();

        return new CreatedUnavailabilityEvent(unavailability.getId(),
            unavailability.getStart(),
            unavailability.getEnd(),
            garage.getId());
    }
}

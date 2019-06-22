package br.com.caelum.garagesharing.calendar.features.register;

import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;
import br.com.caelum.garagesharing.calendar.shared.exceptions.GarageNotFoundException;
import br.com.caelum.garasesharing.event.CreatedUnavailabilityEvent;
import java.time.YearMonth;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final ApplicationEventPublisher publisher;
    private final Converter<UnavailabilityForm, Unavailability> formConverter;
    private final Converter<Unavailability, CreatedUnavailabilityEvent> createdEventConverter;
    private final RegisterUnavailabilityRepository unavailabilities;
    private final FindGarageRepository garages;

    public RegisterService(ApplicationEventPublisher publisher, Converter<UnavailabilityForm, Unavailability> formConverter,
        Converter<Unavailability, CreatedUnavailabilityEvent> createdEventConverter, RegisterUnavailabilityRepository unavailabilities, FindGarageRepository garages) {
        this.publisher = publisher;
        this.formConverter = formConverter;
        this.createdEventConverter = createdEventConverter;
        this.unavailabilities = unavailabilities;
        this.garages = garages;
    }

    YearMonth createUnavailabilityBy(UnavailabilityForm form) {
        String garageId = form.getGarageId();

        Garage garage = garages.findById(garageId)
            .orElseThrow(() -> new GarageNotFoundException(garageId));

        Unavailability unavailability = formConverter.convert(form);
        unavailability.setGarage(garage);

        this.unavailabilities.save(unavailability);

        publisher.publishEvent(createdEventConverter.convert(unavailability));

        return unavailability.getYearMonth();
    }
}

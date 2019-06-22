package br.com.caelum.garagesharing.calendar.features.register;

import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;
import br.com.caelum.garagesharing.calendar.shared.domain.UnavailabilityType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class UnavailabilityFormToUnavailabilityConverter implements Converter<UnavailabilityForm, Unavailability> {

    @Override
    public Unavailability convert(UnavailabilityForm source) {
        return new Unavailability(source.getStart(), source.getEnd(), UnavailabilityType.MANUAL, source.getReason());
    }
}

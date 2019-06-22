package br.com.caelum.garagesharing.calendar.listeners.garage;

import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class CreatedGarageToGarageConverter implements Converter<CreatedGarage, Garage> {

    @Override
    public Garage convert(CreatedGarage event) {
        return new Garage(event.getId());
    }
}

package br.com.caelum.garagesharing.calendar.listeners.garage;

import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import org.springframework.core.convert.converter.Converter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class GarageListener {

    private final Converter<CreatedGarage, Garage> converter;
    private final RegisterGarageRepository repository;

    GarageListener(Converter<CreatedGarage, Garage> converter, RegisterGarageRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @KafkaListener(topics = "${application.topics.garage}")
    void handle(CreatedGarage event) {
        Garage garage = converter.convert(event);

        repository.save(garage);
    }
}

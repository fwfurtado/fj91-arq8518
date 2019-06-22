package br.com.caelum.garagesharing.calendar.features.register;

import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;

public interface RegisterUnavailabilityRepository {
    void save(Unavailability unavailability);
}

package br.com.caelum.garagesharing.calendar.listeners.booking.deletion;

import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;
import java.time.LocalDateTime;
import java.util.Optional;

public interface DeletionUnavailabilityRepository {
    Optional<Unavailability> findUnavailabilityByGarageAndStartAndEnd(Garage garage, LocalDateTime start, LocalDateTime end);
    void delete(Unavailability unavailability);
}

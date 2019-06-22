package br.com.caelum.garagesharing.calendar.shared.repositories;

import br.com.caelum.garagesharing.calendar.features.register.RegisterUnavailabilityRepository;
import br.com.caelum.garagesharing.calendar.listeners.booking.DeletionBookingUnavailabilityOperation;
import br.com.caelum.garagesharing.calendar.listeners.booking.deletion.DeletionUnavailabilityRepository;
import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;
import java.time.LocalDateTime;
import org.springframework.data.repository.Repository;

interface UnavailabilityRepository extends Repository<Unavailability, Long>, RegisterUnavailabilityRepository, DeletionUnavailabilityRepository {


}

package br.com.caelum.garagesharing.calendar.shared.repositories;

import br.com.caelum.garagesharing.calendar.features.register.RegisterUnavailabilityRepository;
import br.com.caelum.garagesharing.calendar.shared.domain.Unavailability;
import org.springframework.data.repository.Repository;

interface UnavailabilityRepository extends Repository<Unavailability, Long>, RegisterUnavailabilityRepository {

}

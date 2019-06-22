package br.com.caelum.garagesharing.calendar.shared.repositories;

import br.com.caelum.garagesharing.calendar.listeners.garage.RegisterGarageRepository;
import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import br.com.caelum.garagesharing.calendar.features.register.FindGarageRepository;
import org.springframework.data.repository.Repository;

interface GarageRepository extends Repository<Garage, Long>, FindGarageRepository, RegisterGarageRepository {

}

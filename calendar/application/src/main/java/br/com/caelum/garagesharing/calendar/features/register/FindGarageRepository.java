package br.com.caelum.garagesharing.calendar.features.register;

import br.com.caelum.garagesharing.calendar.shared.domain.Garage;
import java.util.Optional;

public interface FindGarageRepository {
    Optional<Garage> findById(Long id);
}

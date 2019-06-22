package br.com.caelum.garagesharing.calendar.listeners.garage;

import br.com.caelum.garagesharing.calendar.shared.domain.Garage;

public interface RegisterGarageRepository {
    void save(Garage garage);
}

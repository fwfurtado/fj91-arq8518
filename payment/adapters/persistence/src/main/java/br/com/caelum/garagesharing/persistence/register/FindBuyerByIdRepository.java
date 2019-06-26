package br.com.caelum.garagesharing.persistence.register;

import br.com.caelum.garagesharing.persistence.shared.domain.BuyerEntity;
import java.util.Optional;

public interface FindBuyerByIdRepository {

    Optional<BuyerEntity> findById(Long id);
}

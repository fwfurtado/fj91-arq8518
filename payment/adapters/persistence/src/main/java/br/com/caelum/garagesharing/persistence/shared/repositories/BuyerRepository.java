package br.com.caelum.garagesharing.persistence.shared.repositories;

import br.com.caelum.garagesharing.persistence.register.FindBuyerByIdRepository;
import br.com.caelum.garagesharing.persistence.shared.domain.BuyerEntity;
import org.springframework.data.repository.Repository;

interface BuyerRepository extends Repository<BuyerEntity, Long>, FindBuyerByIdRepository {

}

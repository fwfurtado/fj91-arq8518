package br.com.caelum.garagesharing.persistence.shared.repositories;

import br.com.caelum.garagesharing.persistence.register.PersistPaymentRepository;
import br.com.caelum.garagesharing.persistence.shared.domain.PaymentEntity;
import org.springframework.data.repository.Repository;

interface PaymentRepository extends Repository<PaymentEntity, Long>, PersistPaymentRepository {

}

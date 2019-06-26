package br.com.caelum.garagesharing.persistence.register;

import br.com.caelum.garagesharing.persistence.shared.domain.PaymentEntity;

public interface PersistPaymentRepository {

    void save(PaymentEntity payment);
}

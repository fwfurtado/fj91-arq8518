package br.com.caelum.garagesharing.persistence.register;

import br.com.caelum.garagesharing.stereotype.annotations.Adapter;
import br.com.caelum.garagesharing.payment.domain.Payment;
import br.com.caelum.garagesharing.payment.register.in.PaymentId;
import br.com.caelum.garagesharing.payment.register.in.PersistPaymentPort;
import br.com.caelum.garagesharing.persistence.shared.domain.PaymentEntity;
import org.springframework.core.convert.converter.Converter;

@Adapter
class PersistPaymentAdapter implements PersistPaymentPort {

    private final PersistPaymentRepository repository;
    private final Converter<Payment, PaymentEntity> converter;

    PersistPaymentAdapter(PersistPaymentRepository repository, Converter<Payment, PaymentEntity> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public PaymentId save(Payment payment) {
        PaymentEntity entity = converter.convert(payment);

        repository.save(entity);

        return entity::getId;
    }
}

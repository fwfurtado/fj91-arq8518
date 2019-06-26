package br.com.caelum.garagesharing.persistence.register.mapping;

import br.com.caelum.garagesharing.payment.domain.Buyer;
import br.com.caelum.garagesharing.payment.domain.Payment;
import br.com.caelum.garagesharing.persistence.shared.domain.BuyerEntity;
import br.com.caelum.garagesharing.persistence.shared.domain.PaymentEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class PaymentToPaymentEntityConverter implements Converter<Payment, PaymentEntity> {
    private final Converter<Buyer, BuyerEntity> buyerConverter;

    PaymentToPaymentEntityConverter(Converter<Buyer, BuyerEntity> buyerConverter) {
        this.buyerConverter = buyerConverter;
    }

    @Override
    public PaymentEntity convert(Payment source) {
        BuyerEntity buyer = buyerConverter.convert(source.getBuyer());

        return new PaymentEntity(source.getAmount(), buyer);
    }
}

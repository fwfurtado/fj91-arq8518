package br.com.caelum.garagesharing.persistence.register.mapping;

import br.com.caelum.garagesharing.payment.domain.Buyer;
import br.com.caelum.garagesharing.persistence.shared.domain.BuyerEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class BuyerEntityToBuyerConverter implements Converter<BuyerEntity, Buyer> {

    @Override
    public Buyer convert(BuyerEntity buyer) {
        return new Buyer(buyer.getId(), buyer.getEmail(), buyer.getCreditCard());
    }
}

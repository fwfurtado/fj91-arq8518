package br.com.caelum.garagesharing.persistence.register.mapping;

import br.com.caelum.garagesharing.payment.domain.Buyer;
import br.com.caelum.garagesharing.persistence.shared.domain.BuyerEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class BuyerToBuyerEntityConverter implements Converter<Buyer, BuyerEntity> {

    @Override
    public BuyerEntity convert(Buyer buyer) {
        return new BuyerEntity(buyer.getId(), buyer.getEmail(), buyer.getCreditCard());
    }
}

package br.com.caelum.garagesharing.persistence.register;

import br.com.caelum.garagesharing.stereotype.annotations.Adapter;
import br.com.caelum.garagesharing.payment.domain.Buyer;
import br.com.caelum.garagesharing.payment.register.out.FindBuyerByIdPort;
import br.com.caelum.garagesharing.persistence.shared.domain.BuyerEntity;
import java.util.Optional;
import org.springframework.core.convert.converter.Converter;

@Adapter
class FindBuyerByIdAdapter implements FindBuyerByIdPort {

    private final FindBuyerByIdRepository repository;
    private final Converter<BuyerEntity, Buyer> converter;

    FindBuyerByIdAdapter(FindBuyerByIdRepository repository, Converter<BuyerEntity, Buyer> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Optional<Buyer> findById(Long id) {
        return repository.findById(id)
                    .map(converter::convert);
    }
}

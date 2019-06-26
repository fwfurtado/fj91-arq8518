package br.com.caelum.garagesharing.payment.register.in;

import br.com.caelum.garagesharing.stereotype.annotations.Port;
import br.com.caelum.garagesharing.payment.domain.Buyer;
import br.com.caelum.garagesharing.payment.domain.Payment;
import br.com.caelum.garagesharing.payment.register.out.FindBuyerByIdPort;
import javax.validation.Valid;

@Port
class RegisterPaymentService implements RegisterUseCase {

    private final FindBuyerByIdPort findBuyerByIdPort;
    private final PersistPaymentPort persistPaymentPort;

    RegisterPaymentService(FindBuyerByIdPort findBuyerByIdPort, PersistPaymentPort persistPaymentPort) {
        this.findBuyerByIdPort = findBuyerByIdPort;
        this.persistPaymentPort = persistPaymentPort;
    }

    @Override
    public PaymentId registerPaymentBy(@Valid PaymentCommand command) throws BuyerNotFoundException, InsufficientFundsException {
        Long buyerId = command.getBuyerId();

        Buyer buyer = findBuyerByIdPort.findById(buyerId).orElseThrow(() -> new BuyerNotFoundException(buyerId));

        Payment payment = Payment.create(buyer, command.getAmount());

        return persistPaymentPort.save(payment);
    }
}

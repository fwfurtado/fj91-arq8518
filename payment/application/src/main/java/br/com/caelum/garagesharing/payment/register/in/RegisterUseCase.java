package br.com.caelum.garagesharing.payment.register.in;

import javax.validation.Valid;

public interface RegisterUseCase {

    PaymentId registerPaymentBy(@Valid PaymentCommand command) throws BuyerNotFoundException, InsufficientFundsException;

    final class BuyerNotFoundException extends IllegalArgumentException {

        BuyerNotFoundException(Long buyerId) {
            super(String.format("Cannot found buyer with id %s", buyerId));
        }
    }

    final class InsufficientFundsException extends IllegalStateException {

        InsufficientFundsException() {
            super("Cannot complete your buy, contact your card credit administrator.");
        }
    }
}

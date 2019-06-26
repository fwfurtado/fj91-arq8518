package br.com.caelum.garagesharing.payment.register.in;

import br.com.caelum.garagesharing.payment.domain.Payment;

public interface PersistPaymentPort {

    PaymentId save(Payment payment);
}

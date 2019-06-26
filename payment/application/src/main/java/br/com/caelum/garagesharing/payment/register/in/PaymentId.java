package br.com.caelum.garagesharing.payment.register.in;

public interface PaymentId {

    Long get();

    static PaymentId of(Long id) {
        return () -> id;
    }
}

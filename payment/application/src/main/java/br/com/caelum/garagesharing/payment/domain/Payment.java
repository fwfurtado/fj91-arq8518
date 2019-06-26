package br.com.caelum.garagesharing.payment.domain;

import java.math.BigDecimal;

public class Payment {
    private Long id;
    private final Buyer buyer;
    private final BigDecimal amount;

    private Payment(Buyer buyer, BigDecimal amount) {
        this.buyer = buyer;
        this.amount = amount;
    }

    public static Payment create(Buyer buyer, BigDecimal amount) {
        return new Payment(buyer, amount);
    }

    public Long getId() {
        return id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

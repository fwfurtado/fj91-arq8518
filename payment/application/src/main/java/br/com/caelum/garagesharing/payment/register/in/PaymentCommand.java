package br.com.caelum.garagesharing.payment.register.in;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class PaymentCommand {
    @NotNull
    private Long buyerId;

    @NotNull
    @DecimalMin("10.0")
    private BigDecimal amount;

    public PaymentCommand(Long buyerId, BigDecimal amount) {
        this.buyerId = buyerId;
        this.amount = amount;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

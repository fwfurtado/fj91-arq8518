package br.com.caelum.garagesharing.persistence.shared.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "paymets")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime time;

    @NotNull
    private BigDecimal amount;

    @ManyToOne
    private BuyerEntity buyer;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private PaymentEntity() {
    }

    public PaymentEntity(BigDecimal amount, BuyerEntity buyer) {
        this.time = LocalDateTime.now();
        this.amount = amount;
        this.buyer = buyer;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BuyerEntity getBuyer() {
        return buyer;
    }
}

package br.com.caelum.garagesharing.persistence.shared.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "buyers")
public class BuyerEntity {

    @Id
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String creditCard;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private BuyerEntity() {
    }

    public BuyerEntity(Long id, String email, String creditCard) {
        this.id = id;
        this.email = email;
        this.creditCard = creditCard;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCreditCard() {
        return creditCard;
    }
}
package br.com.caelum.garagesharing.payment.domain;

public class Buyer {

    private final Long id;

    private final String email;

    private final String creditCard;

    public Buyer(Long id, String email, String creditCard) {
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

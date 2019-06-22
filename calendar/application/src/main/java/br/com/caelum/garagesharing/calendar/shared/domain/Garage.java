package br.com.caelum.garagesharing.calendar.shared.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Garage {
    @Id
    private Long id;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private Garage() {
    }

    public Garage(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

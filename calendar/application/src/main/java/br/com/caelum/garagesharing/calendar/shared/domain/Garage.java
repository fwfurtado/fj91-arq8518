package br.com.caelum.garagesharing.calendar.shared.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Garage {
    @Id
    private String id;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private Garage() {
    }

    public Garage(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

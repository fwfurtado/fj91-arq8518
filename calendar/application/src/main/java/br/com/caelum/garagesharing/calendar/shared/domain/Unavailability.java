package br.com.caelum.garagesharing.calendar.shared.domain;

import java.time.LocalDateTime;
import java.time.YearMonth;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Unavailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Garage garage;

    @NotNull
    private LocalDateTime start;

    @NotNull
    private LocalDateTime end;

    @NotNull
    private String reason;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private Unavailability() {
    }

    public Unavailability(LocalDateTime start, LocalDateTime end, String reason) {
        this.start = start;
        this.end = end;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public Garage getGarage() {
        return garage;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public String getReason() {
        return reason;
    }

    public YearMonth getYearMonth() {
        return YearMonth.from(start);
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }
}
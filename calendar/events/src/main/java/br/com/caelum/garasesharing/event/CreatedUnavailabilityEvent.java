package br.com.caelum.garasesharing.event;

import java.time.LocalDateTime;

public class CreatedUnavailabilityEvent extends Event {

    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long garageId;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private CreatedUnavailabilityEvent() {
    }

    public CreatedUnavailabilityEvent(Long id, LocalDateTime start, LocalDateTime end, Long garageId) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.garageId = garageId;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Long getGarageId() {
        return garageId;
    }
}

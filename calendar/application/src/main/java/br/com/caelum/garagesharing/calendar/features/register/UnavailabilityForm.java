package br.com.caelum.garagesharing.calendar.features.register;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

class UnavailabilityForm {

    @JsonIgnore
    private Long garageId;

    @NotNull
    @FutureOrPresent
    private LocalDateTime start;

    @Future
    private LocalDateTime end;

    @NotBlank
    @Size(max = 160)
    private String reason;

    /**
     * @deprecated frameworks only
     */
    @Deprecated
    private UnavailabilityForm() {
    }

    public UnavailabilityForm(Long garageId, LocalDateTime start, LocalDateTime end, String reason) {
        this.garageId = garageId;
        this.start = start;
        this.end = end;
        this.reason = reason;
    }

    public Long getGarageId() {
        return garageId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    void setGarageId(Long garageId) {
        this.garageId = garageId;
    }

    public String getReason() {
        return reason;
    }
}

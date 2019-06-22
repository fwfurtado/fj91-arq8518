package br.com.caelum.garagesharing.calendar.listeners.booking;

import java.time.LocalDateTime;

public class BookingChangeStatusEvent {
    private BookingStatus status;
    private String garageId;
    private LocalDateTime start;
    private LocalDateTime end;

    public BookingStatus getStatus() {
        return status;
    }

    public String getGarageId() {
        return garageId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}

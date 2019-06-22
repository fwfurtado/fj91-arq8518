package br.com.caelum.garasesharing.event;

import java.time.LocalDateTime;

public abstract class Event {

    private LocalDateTime timestamp = LocalDateTime.now();

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

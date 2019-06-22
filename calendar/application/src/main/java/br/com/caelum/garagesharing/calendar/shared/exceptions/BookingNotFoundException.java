package br.com.caelum.garagesharing.calendar.shared.exceptions;

public class BookingNotFoundException extends IllegalArgumentException {

    public BookingNotFoundException(Long bookingId) {
        super(String.format("Cannot find booking with id '%s'", bookingId));
    }
}

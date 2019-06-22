package br.com.caelum.garagesharing.calendar.shared.exceptions;

public class GarageNotFoundException extends IllegalArgumentException {

    public GarageNotFoundException(String garageId) {
        super(String.format("Cannot find garage with id '%s'", garageId));
    }
}

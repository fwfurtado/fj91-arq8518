package br.com.caelum.garagesharing.calendar.features.register;

import static org.springframework.http.ResponseEntity.notFound;

import br.com.caelum.garagesharing.calendar.shared.exceptions.GarageNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class RegisterExceptionHandler {

    private static Logger LOG = LoggerFactory.getLogger(RegisterExceptionHandler.class);

    @ExceptionHandler(GarageNotFoundException.class)
    ResponseEntity<?> handle(GarageNotFoundException e) {
        LOG.warn("[REGISTER][GARAGE][NOT_FOUND] {}", e.getMessage());

        return notFound().build();
    }
}

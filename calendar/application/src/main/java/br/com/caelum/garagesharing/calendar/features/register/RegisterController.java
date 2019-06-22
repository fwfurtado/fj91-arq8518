package br.com.caelum.garagesharing.calendar.features.register;

import static org.springframework.http.ResponseEntity.created;

import br.com.caelum.garagesharing.annotations.CalendarController;
import java.net.URI;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@CalendarController
class RegisterController {

    private static final DateTimeFormatter yearMonthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
    private final RegisterService service;

    RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping("garages/{garageId}")
    ResponseEntity<?> createBy(@PathVariable Long garageId, @Valid @RequestBody UnavailabilityForm form, UriComponentsBuilder uriBuilder) {

        form.setGarageId(garageId);

        YearMonth yearMonth = service.createUnavailabilityBy(form);

        URI uri = uriBuilder.path("garages/{garageId}/{yearMonth}").build(garageId, yearMonth.format(yearMonthFormatter));

        return created(uri).build();
    }
}

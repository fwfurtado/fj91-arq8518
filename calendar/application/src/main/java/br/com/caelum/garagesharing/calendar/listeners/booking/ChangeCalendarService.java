package br.com.caelum.garagesharing.calendar.listeners.booking;

import br.com.caelum.garasesharing.event.Event;
import org.springframework.stereotype.Service;

@Service
class ChangeCalendarService {

    private final CreationBookingUnavailabilityOperation creationService;
    private final DeletionBookingUnavailabilityOperation deletionService;

    ChangeCalendarService(CreationBookingUnavailabilityOperation creationService, DeletionBookingUnavailabilityOperation deletionService) {
        this.creationService = creationService;
        this.deletionService = deletionService;
    }

    Event onChangeCalendarBy(BookingChangeStatusEvent event) {
        BookingStatus status = event.getStatus();

        if(cannotBeHandling(status)) {
            throw new IllegalStateException(String.format("Cannot handling status '%s'", status));
        }

        if (status == BookingStatus.PAYED) {
            return creationService.createUnavailabilityBy(event);
        }

        return deletionService.deleteUnavailabilityBy(event);
    }

    private boolean cannotBeHandling(BookingStatus status) {
        return status != BookingStatus.PAYED && status != BookingStatus.CANCELLED;
    }
}

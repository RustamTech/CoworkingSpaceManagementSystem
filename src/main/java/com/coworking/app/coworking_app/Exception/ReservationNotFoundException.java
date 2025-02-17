package com.coworking.app.coworking_app.Exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Long userId) {
        super("No reservations found for user with ID " + userId);
    }
}

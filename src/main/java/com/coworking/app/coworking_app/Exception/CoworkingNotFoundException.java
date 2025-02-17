package com.coworking.app.coworking_app.Exception;

public class CoworkingNotFoundException extends RuntimeException {
    public CoworkingNotFoundException(Long coworkingId) {
        super("Coworking space with ID " + coworkingId + " not found");
    }
}

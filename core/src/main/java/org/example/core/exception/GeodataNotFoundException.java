package org.example.core.exception;

public class GeodataNotFoundException extends MyResourceNotFoundException {
    public GeodataNotFoundException() {
        this("Geo coord not found");
    }

    public GeodataNotFoundException(String message) {
        super(message);

    }
}
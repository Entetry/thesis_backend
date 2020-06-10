package org.example.core.exception;

public class PorodaNotFoundException extends MyResourceNotFoundException {
    public PorodaNotFoundException() {
        this("Trial plot not found");
    }

    public PorodaNotFoundException(String message) {
        super(message);

    }
}
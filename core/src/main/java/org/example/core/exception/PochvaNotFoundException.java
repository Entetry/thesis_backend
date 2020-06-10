package org.example.core.exception;

public class PochvaNotFoundException  extends MyResourceNotFoundException {
    public PochvaNotFoundException() {
        this("Pochva  not found");
    }

    public PochvaNotFoundException(String message) {
        super(message);

    }
}
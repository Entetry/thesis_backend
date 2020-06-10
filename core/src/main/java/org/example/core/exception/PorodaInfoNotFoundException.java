package org.example.core.exception;

public class PorodaInfoNotFoundException  extends MyResourceNotFoundException {
    public PorodaInfoNotFoundException() {
        this("Poroda info  not found");
    }

    public PorodaInfoNotFoundException(String message) {
        super(message);

    }
}
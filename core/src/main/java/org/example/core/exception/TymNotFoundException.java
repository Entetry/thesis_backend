package org.example.core.exception;

public class TymNotFoundException extends MyResourceNotFoundException {
    public TymNotFoundException() {
        this("Tym not found");
    }

    public TymNotFoundException(String message) {
        super(message);

    }
}
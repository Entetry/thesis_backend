package org.example.core.exception;

public class OblastNotFoundException extends MyResourceNotFoundException {
    public OblastNotFoundException() {
        this("Oblast  not found");
    }

    public OblastNotFoundException(String message) {
        super(message);

    }
}
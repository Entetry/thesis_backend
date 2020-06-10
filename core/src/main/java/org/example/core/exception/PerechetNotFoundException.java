package org.example.core.exception;

public class PerechetNotFoundException extends MyResourceNotFoundException {
    public PerechetNotFoundException() {
        this("Perechet  not found");
    }

    public PerechetNotFoundException(String message) {
        super(message);

    }}

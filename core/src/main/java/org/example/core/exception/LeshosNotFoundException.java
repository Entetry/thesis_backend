package org.example.core.exception;

public class LeshosNotFoundException extends MyResourceNotFoundException {
    public LeshosNotFoundException() {
        this("Leshos  not found");
    }

    public LeshosNotFoundException(String message) {
        super(message);

    }}
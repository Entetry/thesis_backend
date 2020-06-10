package org.example.core.exception;

public class LesnichestvoNotFoundException extends MyResourceNotFoundException {
    public LesnichestvoNotFoundException() {
        this("Lesnichestvo  not found");
    }

    public LesnichestvoNotFoundException(String message) {
        super(message);

    }}
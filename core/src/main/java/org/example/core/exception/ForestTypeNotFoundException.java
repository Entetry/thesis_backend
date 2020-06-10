package org.example.core.exception;

public class ForestTypeNotFoundException extends MyResourceNotFoundException {
    public ForestTypeNotFoundException() {
        this("Forest type not found");
    }

    public ForestTypeNotFoundException(String message) {
        super(message);

    }
}
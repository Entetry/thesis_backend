package org.example.core.exception;

public class PlhoNotFoundException extends MyResourceNotFoundException {
public PlhoNotFoundException() {
        this("Phlo  not found");
        }

public PlhoNotFoundException(String message) {
        super(message);

        }
        }
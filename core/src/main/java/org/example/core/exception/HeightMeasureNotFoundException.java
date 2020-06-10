package org.example.core.exception;

public class HeightMeasureNotFoundException extends MyResourceNotFoundException {
    public HeightMeasureNotFoundException() {
        this("Height measure not found");
    }

    public HeightMeasureNotFoundException(String message) {
        super(message);

    }
}
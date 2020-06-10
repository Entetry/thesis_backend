package org.example.core.exception;

public class RayonNotFoundException  extends MyResourceNotFoundException {
    public RayonNotFoundException() {
        this("Rayon  not found");
    }

    public RayonNotFoundException(String message) {
        super(message);

    }
}
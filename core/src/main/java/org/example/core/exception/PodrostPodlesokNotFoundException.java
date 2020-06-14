package org.example.core.exception;

public class PodrostPodlesokNotFoundException extends MyResourceNotFoundException {
    public PodrostPodlesokNotFoundException() {
        this("Podrost and Podlesok  not found");
    }

    public PodrostPodlesokNotFoundException(String message) {
        super(message);

    }
}
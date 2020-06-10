package org.example.core.exception;

public class TrialPlotNotFoundException extends MyResourceNotFoundException {
public TrialPlotNotFoundException() {
        this("Trial plot not found");
        }

public TrialPlotNotFoundException(String message) {
        super(message);

        }
        }
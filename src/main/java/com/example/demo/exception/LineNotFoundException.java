package com.example.demo.exception;

public class LineNotFoundException extends RuntimeException {
    public LineNotFoundException(String message) {
        super(message);
    }

    public LineNotFoundException() {
    }
}

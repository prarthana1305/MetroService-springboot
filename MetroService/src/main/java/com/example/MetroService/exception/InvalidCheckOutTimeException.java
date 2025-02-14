package com.example.MetroService.exception;

public class InvalidCheckOutTimeException extends RuntimeException {
    public InvalidCheckOutTimeException(String message) {
        super(message);
    }
}

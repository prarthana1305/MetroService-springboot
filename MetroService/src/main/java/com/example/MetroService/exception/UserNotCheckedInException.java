package com.example.MetroService.exception;

public class UserNotCheckedInException extends RuntimeException {
    public UserNotCheckedInException(String message) {
        super(message);
    }
}

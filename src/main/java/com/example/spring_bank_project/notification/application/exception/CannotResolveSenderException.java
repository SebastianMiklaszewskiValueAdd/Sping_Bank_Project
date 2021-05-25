package com.example.spring_bank_project.notification.application.exception;

public class CannotResolveSenderException extends RuntimeException {
    public CannotResolveSenderException(String message) {
        super(message);
    }
}

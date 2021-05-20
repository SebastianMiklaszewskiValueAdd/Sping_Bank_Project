package com.example.spring_bank_project.account.domain.exception;

public class InvalidPinException extends Exception {
    private InvalidPinException(String message) {
        super(message);
    }

    public static InvalidPinException pinIsIncorrect() {
        return new InvalidPinException("Pin is incorrect. Pin has to contains 4 digits. Try again.");
    }
}

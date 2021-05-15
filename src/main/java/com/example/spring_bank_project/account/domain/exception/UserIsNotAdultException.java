package com.example.spring_bank_project.account.domain.exception;

public class UserIsNotAdultException extends Exception {
    public UserIsNotAdultException() {
        super("You are not adult. To create account in our bank you have to have at least 18 years. Try again later.");
    }
}

package com.example.spring_bank_project.shared.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BrokenContractException extends RuntimeException {
    public BrokenContractException(String message) {
        super(message);
    }
}

package com.example.spring_bank_project.shared.domain.valueObject;

import lombok.Value;

@Value
public class Email {
    @javax.validation.constraints.Email
    String email;
}

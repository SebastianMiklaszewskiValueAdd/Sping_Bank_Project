package com.example.spring_bank_project.account.domain.valueObject;

import lombok.Value;

@Value
public class Email {
    @javax.validation.constraints.Email
    String email;
}

package com.example.spring_bank_project.account.domain.model;

import com.example.spring_bank_project.account.domain.valueObject.*;
import lombok.Value;

@Value
public class NewUser {
    UserId userId;
    FirstName firstName;
    LastName lastName;
    BirthDate birthDate;
    Email email;
    EncodedPin pin;
}

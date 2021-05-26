package com.example.spring_bank_project.account.domain.model;

import com.example.spring_bank_project.account.domain.valueObject.*;
import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.EncodedPin;
import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.Instant;

@Value
@AllArgsConstructor
public class NewUser {
    UserId userId;
    FirstName firstName;
    LastName lastName;
    BirthDate birthDate;
    Email email;
    EncodedPin pin;
    Instant createdAt;
}

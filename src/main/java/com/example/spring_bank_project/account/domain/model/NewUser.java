package com.example.spring_bank_project.account.domain.model;

import com.example.spring_bank_project.account.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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

package com.example.spring_bank_project.account.application.useCase.addNewUser;

import com.example.spring_bank_project.account.domain.valueObject.*;
import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;
import com.example.spring_bank_project.shared.domain.valueObject.UserId;

import java.time.Instant;

public interface AddNewUserContract {
    UserId getId();
    FirstName getFirstName();
    LastName getLastName();
    BirthDate getBirthDate();
    Email getEmail();
    Pin getPin();
    Instant getCreatedAt();
}

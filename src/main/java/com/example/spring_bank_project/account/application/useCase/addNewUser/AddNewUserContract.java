package com.example.spring_bank_project.account.application.useCase.addNewUser;

import com.example.spring_bank_project.account.domain.valueObject.*;

public interface AddNewUserContract {
    UserId getId();
    FirstName getFirstName();
    LastName getLastName();
    BirthDate getBirthDate();
    Email getEmail();
    Pin getPin();
}

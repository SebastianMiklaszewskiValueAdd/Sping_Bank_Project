package com.example.spring_bank_project.account.domain.factory;

import com.example.spring_bank_project.account.domain.model.NewUser;
import com.example.spring_bank_project.account.domain.valueObject.*;
import org.springframework.stereotype.Service;

@Service
public class UserModelFactory {
    public NewUser createNewUser(UserId userId,
            FirstName firstName,
            LastName lastName,
            BirthDate birthDate,
            Email email,
            EncodedPin pin) {
        return new NewUser(userId, firstName, lastName, birthDate, email, pin);
    }
}

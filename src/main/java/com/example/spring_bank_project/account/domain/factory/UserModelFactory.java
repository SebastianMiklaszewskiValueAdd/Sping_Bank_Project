package com.example.spring_bank_project.account.domain.factory;

import com.example.spring_bank_project.account.domain.model.NewUser;
import com.example.spring_bank_project.account.domain.valueObject.*;
import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.EncodedPin;
import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class UserModelFactory {
    public NewUser createNewUser(UserId userId,
            FirstName firstName,
            LastName lastName,
            BirthDate birthDate,
            Email email,
            EncodedPin pin,
            Instant createdAt) {
        return new NewUser(userId, firstName, lastName, birthDate, email, pin, createdAt);
    }
}

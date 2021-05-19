package com.example.spring_bank_project.account.infrastructure.gateway.http.controller.user;

import com.example.spring_bank_project.account.application.useCase.addNewUser.AddNewUserContract;
import com.example.spring_bank_project.account.domain.valueObject.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
public class AddNewUserRequest implements AddNewUserContract {
    private UserId id;

    private FirstName firstName;
    private LastName lastName;
    private BirthDate birthDate;
    private Email email;
    private Pin pin;
    private Instant createdAt = Instant.now();

    public void setId(String id) {
        this.id = new UserId(UUID.fromString(id));
    }
}

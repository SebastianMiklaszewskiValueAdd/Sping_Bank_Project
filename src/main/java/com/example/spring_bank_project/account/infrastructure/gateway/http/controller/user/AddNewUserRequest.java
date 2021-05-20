package com.example.spring_bank_project.account.infrastructure.gateway.http.controller.user;

import com.example.spring_bank_project.account.application.useCase.addNewUser.AddNewUserContract;
import com.example.spring_bank_project.account.domain.valueObject.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddNewUserRequest implements AddNewUserContract {
    private UserId id;
    private FirstName firstName;
    private LastName lastName;
    private BirthDate birthDate;
    private Email email;
    private Pin pin;
}

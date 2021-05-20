package com.example.spring_bank_project.account.application;

import com.example.spring_bank_project.account.application.useCase.addNewUser.AddNewUserCommand;
import com.example.spring_bank_project.account.application.useCase.addNewUser.AddNewUserContract;
import com.example.spring_bank_project.account.application.useCase.addNewUser.AddNewUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserFacade {
    private final AddNewUserHandler handler;

    public void addNewUser(AddNewUserContract contract) {
        this.handler.handle(new AddNewUserCommand(contract));
    }
}

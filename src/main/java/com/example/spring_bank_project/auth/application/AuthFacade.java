package com.example.spring_bank_project.auth.application;

import com.example.spring_bank_project.auth.application.useCase.login.LoginContract;
import com.example.spring_bank_project.auth.application.useCase.login.LoginHandler;
import com.example.spring_bank_project.auth.application.useCase.login.LoginQuery;
import com.example.spring_bank_project.auth.application.useCase.login.UserAuthorizedView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthFacade {
    private final LoginHandler handler;

    public UserAuthorizedView login(LoginContract request) {
        return this.handler.handle(new LoginQuery(request));
    }
}

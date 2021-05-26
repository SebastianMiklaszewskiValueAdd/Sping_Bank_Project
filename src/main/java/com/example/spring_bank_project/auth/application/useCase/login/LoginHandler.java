package com.example.spring_bank_project.auth.application.useCase.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginHandler {
    private final LoginServicePort loginService;

    public UserAuthorizedView handle(LoginQuery query) {
        var contract = query.getContract();

        var token = this.loginService.login(contract.getEmail(), contract.getPin());

        return new UserAuthorizedView(token.getToken());
    }
}

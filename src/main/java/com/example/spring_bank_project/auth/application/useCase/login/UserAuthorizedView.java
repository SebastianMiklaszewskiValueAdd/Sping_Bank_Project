package com.example.spring_bank_project.auth.application.useCase.login;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserAuthorizedView {
    @JsonSerialize
    private final String token;
}

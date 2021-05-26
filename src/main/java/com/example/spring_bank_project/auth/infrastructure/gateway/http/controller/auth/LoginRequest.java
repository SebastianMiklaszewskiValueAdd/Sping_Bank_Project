package com.example.spring_bank_project.auth.infrastructure.gateway.http.controller.auth;

import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;
import com.example.spring_bank_project.auth.application.useCase.login.LoginContract;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class LoginRequest implements LoginContract {
    private Pin pin;
    private Email email;
}

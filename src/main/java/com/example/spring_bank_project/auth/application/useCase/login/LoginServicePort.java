package com.example.spring_bank_project.auth.application.useCase.login;

import com.example.spring_bank_project.auth.application.dto.AuthToken;
import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;

public interface LoginServicePort {
    AuthToken login(Email email, Pin pin);
}

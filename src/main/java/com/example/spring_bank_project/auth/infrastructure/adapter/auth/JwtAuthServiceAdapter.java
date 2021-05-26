package com.example.spring_bank_project.auth.infrastructure.adapter.auth;

import com.example.spring_bank_project.auth.application.dto.AuthToken;
import com.example.spring_bank_project.auth.application.useCase.login.LoginServicePort;
import com.example.spring_bank_project.auth.infrastructure.adapter.dpi.AuthAccountDpiAdapter;
import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class JwtAuthServiceAdapter implements LoginServicePort {
    private final AuthAccountDpiAdapter authAccountDpi;
    private final JwtTokenFactory factory;

    @Override
    public AuthToken login(Email email, Pin pin) {
        var authenticatedUserId = this.authAccountDpi.fetchUserIdIfCredentialsCorrect(email, pin);

        return new AuthToken(this.factory.createToken(authenticatedUserId));
    }
}

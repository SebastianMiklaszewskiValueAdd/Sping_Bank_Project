package com.example.spring_bank_project.auth.infrastructure.adapter.dpi;

import com.example.spring_bank_project.account.application.UserAuthDpiFacade;
import com.example.spring_bank_project.auth.application.valueObject.AuthenticatedUserId;
import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;
import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import com.example.spring_bank_project.shared.infrastructure.auth.UserSecurityData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthAccountDpiAdapter {
    private final UserAuthDpiFacade userAuthDpiFacade;

    public AuthenticatedUserId fetchUserIdIfCredentialsCorrect(Email email, Pin pin) {
        return AuthenticatedUserId.fromUserId(this.userAuthDpiFacade.fetchUserIdFromUserByEmailIfPinIsCorrect(email,
                pin));
    }

    public UserSecurityData fetchUserSecurityDataOrFail(UserId userId) {
        return this.userAuthDpiFacade.fetchUserSecurityDataOrFail(userId);
    }
}

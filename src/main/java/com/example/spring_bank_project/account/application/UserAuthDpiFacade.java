package com.example.spring_bank_project.account.application;

import com.example.spring_bank_project.account.application.dpi.UserAuthDpiServiceInterface;
import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;
import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthDpiFacade {
    private final UserAuthDpiServiceInterface userAuthDpiService;

    public UserId fetchUserIdFromUserByEmailIfPinIsCorrect(Email email, Pin pin) {
        return this.userAuthDpiService.fetchUserIdFromUserByEmailIfPinIsCorrect(email, pin);
    }
}

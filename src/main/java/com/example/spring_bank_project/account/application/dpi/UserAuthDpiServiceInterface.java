package com.example.spring_bank_project.account.application.dpi;

import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;
import com.example.spring_bank_project.shared.infrastructure.auth.UserSecurityData;

public interface UserAuthDpiServiceInterface {
    UserId fetchUserIdFromUserByEmailIfPinIsCorrect(Email email, Pin pin);
    UserSecurityData fetchUserSecurityDataOrFail(UserId userId);
}

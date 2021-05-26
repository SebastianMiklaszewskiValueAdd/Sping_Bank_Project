package com.example.spring_bank_project.account.application.dpi;

import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;

public interface UserAuthDpiServiceInterface {
    UserId fetchUserIdFromUserByEmailIfPinIsCorrect(Email email, Pin pin);
}

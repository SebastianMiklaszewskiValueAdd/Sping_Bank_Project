package com.example.spring_bank_project.account.application.useCase.addNewUser;

import com.example.spring_bank_project.account.domain.valueObject.EncodedPin;
import com.example.spring_bank_project.account.domain.valueObject.Pin;

public interface PinEncoder {
    EncodedPin encode(Pin pin);
}

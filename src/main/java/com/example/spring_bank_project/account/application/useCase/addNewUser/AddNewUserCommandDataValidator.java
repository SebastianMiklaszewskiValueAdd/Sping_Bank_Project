package com.example.spring_bank_project.account.application.useCase.addNewUser;

import com.example.spring_bank_project.account.domain.exception.InvalidPinException;
import com.example.spring_bank_project.account.domain.exception.UserIsNotAdultException;
import com.example.spring_bank_project.account.domain.valueObject.BirthDate;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AddNewUserCommandDataValidator {
    public void assertUserIsAdult(BirthDate birthDate, LocalDate now) throws UserIsNotAdultException {
        if (!birthDate.getBirthDate().isBefore(now.minusYears(18))) {
            throw new UserIsNotAdultException();
        }
    }

    public void assertPinIsCorrect(Pin pin) throws InvalidPinException {
        if (!pin.getPin().matches("\\d{4}")) {
            throw InvalidPinException.pinIsIncorrect();
        }
    }
}

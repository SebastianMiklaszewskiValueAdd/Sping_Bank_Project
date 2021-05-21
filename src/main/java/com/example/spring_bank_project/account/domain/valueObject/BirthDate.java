package com.example.spring_bank_project.account.domain.valueObject;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BirthDate {
    private final LocalDate birthDate;

    public BirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }
}

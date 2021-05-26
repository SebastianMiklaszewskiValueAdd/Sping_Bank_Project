package com.example.spring_bank_project.account.domain.valueObject;

import lombok.Value;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Value
public class DailyPaymentsLimit {
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "9999")
    @Digits(integer = 4, fraction = 2)
        BigDecimal limit;
}

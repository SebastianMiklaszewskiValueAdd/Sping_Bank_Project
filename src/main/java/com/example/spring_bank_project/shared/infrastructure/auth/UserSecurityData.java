package com.example.spring_bank_project.shared.infrastructure.auth;

import com.example.spring_bank_project.shared.domain.valueObject.EncodedPin;
import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import lombok.Value;

@Value
public class UserSecurityData {
    UserId userId;
    EncodedPin encodedPin;
}

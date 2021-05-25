package com.example.spring_bank_project.notification.domain.valueObject;

import lombok.Value;

@Value
public class Contact {
    String contact;
    ContactType contactType;
}

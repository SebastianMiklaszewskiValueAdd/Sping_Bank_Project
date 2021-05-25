package com.example.spring_bank_project.notification.application.useCase.sendAccountWasCreatedNotification;

import com.example.spring_bank_project.notification.application.port.Notification;
import com.example.spring_bank_project.notification.domain.valueObject.Contact;
import lombok.Value;

@Value
public class AccountWasCreatedEmailNotification implements Notification {
    String message;
    Contact contact;
    String subject = "Account created";
}

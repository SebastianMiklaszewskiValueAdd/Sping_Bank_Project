package com.example.spring_bank_project.notification.infrastructure.gateway.listener;

import com.example.spring_bank_project.notification.application.useCase.sendAccountWasCreatedNotification.SendAccountWasCreatedNotificationContract;
import com.example.spring_bank_project.notification.domain.valueObject.Contact;
import lombok.Value;

import java.time.Instant;

@Value
public class SendAccountWasCreatedNotificationDto implements SendAccountWasCreatedNotificationContract {
    Contact contact;
    Instant createdAt;
    String accountType;
    String recipientFullName;
}

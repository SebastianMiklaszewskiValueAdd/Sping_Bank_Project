package com.example.spring_bank_project.notification.infrastructure.adapter;

import com.example.spring_bank_project.notification.application.exception.CannotResolveSenderException;
import com.example.spring_bank_project.notification.application.port.Notification;
import com.example.spring_bank_project.notification.application.port.NotificationSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("strategy")
public class NotificationSenderStrategy implements NotificationSender {
    @Qualifier("email")
    private final NotificationSender emailNotificationSender;

    @Override
    public void send(Notification notification) {
        var contactType = notification.getContact().getContactType();

        switch (contactType) {
            case EMAIL -> this.emailNotificationSender.send(notification);
            default -> throw new CannotResolveSenderException(String.format("Cannot resolve notification sender for: %s",
                    contactType));
        }
    }
}

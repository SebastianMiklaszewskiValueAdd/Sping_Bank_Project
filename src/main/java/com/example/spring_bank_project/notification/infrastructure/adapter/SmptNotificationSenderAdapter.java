package com.example.spring_bank_project.notification.infrastructure.adapter;

import com.example.spring_bank_project.notification.application.port.Notification;
import com.example.spring_bank_project.notification.application.port.NotificationSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Qualifier("email")
@RequiredArgsConstructor
class SmptNotificationSenderAdapter implements NotificationSender {
    private final JavaMailSender sender;

    @Override
    public void send(Notification notification) {
        var message = new SimpleMailMessage();

        message.setFrom("spring.bank@email.com");
        message.setTo(notification.getContact().getContact());
        message.setSubject(notification.getSubject());
        message.setText(notification.getMessage());

        this.sender.send(message);
    }
}

package com.example.spring_bank_project.notification.application.port;

public interface NotificationSender {
    void send(Notification notification);
}

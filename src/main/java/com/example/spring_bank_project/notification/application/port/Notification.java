package com.example.spring_bank_project.notification.application.port;

import com.example.spring_bank_project.notification.domain.valueObject.Contact;

public interface Notification {
    Contact getContact();
    String getMessage();
    String getSubject();
}

package com.daniellsantiago.designpatterns.application.service;

import com.daniellsantiago.designpatterns.domain.User;
import org.springframework.stereotype.Service;

@Service("emailNotificationService")
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user) {
        System.out.println("Sending email to: " + user.getEmail());
    }
}

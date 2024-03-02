package com.daniellsantiago.designpatterns.application.service;

import com.daniellsantiago.designpatterns.domain.User;
import org.springframework.stereotype.Service;

@Service("whatsappNotificationService")
public class WhatsappNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user) {
        System.out.println("Sending whatsapp to: " + user.getUsername());
    }
}

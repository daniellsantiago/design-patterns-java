package com.daniellsantiago.designpatterns.application.service;

import com.daniellsantiago.designpatterns.domain.User;

public interface NotificationService {
    void sendNotification(User user);
}

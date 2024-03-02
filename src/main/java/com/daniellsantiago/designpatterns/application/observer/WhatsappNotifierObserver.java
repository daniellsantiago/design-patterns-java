package com.daniellsantiago.designpatterns.application.observer;

import com.daniellsantiago.designpatterns.domain.Observer;
import com.daniellsantiago.designpatterns.domain.User;

public class WhatsappNotifierObserver implements Observer<User> {

    @Override
    public void update(User message) {
        System.out.println("Sending whatsapp notification to User: " + message.getUsername());
    }
}

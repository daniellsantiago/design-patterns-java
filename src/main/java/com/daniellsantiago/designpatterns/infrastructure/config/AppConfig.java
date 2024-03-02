package com.daniellsantiago.designpatterns.infrastructure.config;

import com.daniellsantiago.designpatterns.application.observer.EmailNotifierObserver;
import com.daniellsantiago.designpatterns.application.observer.WhatsappNotifierObserver;
import com.daniellsantiago.designpatterns.application.subject.UserCreationSubject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserCreationSubject userCreationSubject() {
        var subject = new UserCreationSubject();
        subject.addObserver(new EmailNotifierObserver());
        subject.addObserver(new WhatsappNotifierObserver());
        return subject;
    }
}

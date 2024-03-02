package com.daniellsantiago.designpatterns.application.subject;

import com.daniellsantiago.designpatterns.domain.Observer;
import com.daniellsantiago.designpatterns.domain.Subject;
import com.daniellsantiago.designpatterns.domain.User;
import java.util.ArrayList;
import java.util.List;

public class UserCreationSubject implements Subject<User> {
    private final List<Observer<User>> observers = new ArrayList<>();


    @Override
    public void addObserver(Observer<User> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<User> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(User message) {
        for (Observer<User> observer : observers) {
            observer.update(message);
        }
    }
}

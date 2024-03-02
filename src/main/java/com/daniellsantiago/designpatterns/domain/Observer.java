package com.daniellsantiago.designpatterns.domain;

public interface Observer<T> {
    void update(T message);
}

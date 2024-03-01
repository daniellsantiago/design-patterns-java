package com.daniellsantiago.designpatterns.application.repository;

import com.daniellsantiago.designpatterns.domain.User;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findUserByUsername(String username);
}

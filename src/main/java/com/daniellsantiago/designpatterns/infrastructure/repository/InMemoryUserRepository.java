package com.daniellsantiago.designpatterns.infrastructure.repository;

import com.daniellsantiago.designpatterns.domain.User;
import com.daniellsantiago.designpatterns.application.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return users.stream()
          .filter(user -> user.getUsername().equals(username))
          .findFirst();
    }
}

package com.daniellsantiago.designpatterns.application.service;

import com.daniellsantiago.designpatterns.application.repository.UserRepository;
import com.daniellsantiago.designpatterns.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AddressService addressService;

    public void saveUser(String username, String email, String password, String zipCode) {
        var address = addressService.findAddressByZipCode(zipCode).orElse(null);
        var user = User.builder()
          .username(username)
          .email(email)
          .password(password)
          .address(address)
          .build();
        userRepository.save(user);
    }
}

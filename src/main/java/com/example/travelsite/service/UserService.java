package com.example.travelsite.service;

import com.example.travelsite.entity.User;
import com.example.travelsite.exception.AppException;
import com.example.travelsite.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) {
        //パスワードハッシュ化
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);

        userRepository.save(user);
    }
}

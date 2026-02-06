package com.example.travelsite.service;

import com.example.travelsite.entity.User;
import com.example.travelsite.repository.UserRepository;
import com.example.travelsite.security.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiseImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("ユーザーが存在しません"));

        return new UserDetailsImpl(user);
    }
}

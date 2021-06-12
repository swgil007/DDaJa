package com.ddaja.ddaja.service;

import java.util.Optional;

import com.ddaja.ddaja.domain.user.User;
import com.ddaja.ddaja.repository.user.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public User findUserInfoById(String id) {
        return userRepository.findById(id);
    }
}

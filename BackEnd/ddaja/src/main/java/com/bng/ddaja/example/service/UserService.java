package com.bng.ddaja.example.service;

import java.util.Optional;

import com.bng.ddaja.common.domain.user.User;
import com.bng.ddaja.example.dto.UserDTO;
import com.bng.ddaja.example.repository.user.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{
    
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public UserDTO findUserInfoById(String id) {
        User user = userRepository.findById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByName(userName);
    }
}

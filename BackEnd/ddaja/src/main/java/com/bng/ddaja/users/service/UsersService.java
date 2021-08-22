package com.bng.ddaja.users.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.users.dto.UserDTO;
import com.bng.ddaja.users.repository.UsersRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class UsersService {
    private UsersRepository usersRepository;

    public List<UserDTO> getUsers() {
        return usersRepository.findAll().stream().map(v -> new UserDTO(v)).collect(Collectors.toList());
    }

    public UserDTO getUserById(long id) {
        return new UserDTO(usersRepository.findById(id));
    }

}

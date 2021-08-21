package com.bng.ddaja.users.service;

import java.util.List;

import com.bng.ddaja.users.repository.UsersRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class UsersService {
    private UsersRepository usersRepository;

}

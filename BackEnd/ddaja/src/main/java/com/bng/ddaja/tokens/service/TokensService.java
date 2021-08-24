package com.bng.ddaja.tokens.service;

import com.bng.ddaja.tokens.repository.TokensRepository;
import com.bng.ddaja.users.service.UsersService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class TokensService {
    private TokensRepository tokensRepository;
    private UsersService usersService;

}

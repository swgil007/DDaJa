package com.bng.ddaja.tokens.controller;

import com.bng.ddaja.tokens.service.TokensService;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class TokensController {
    private TokensService tokensService;
}

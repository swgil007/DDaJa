package com.bng.ddaja.tokens.repository;

import com.bng.ddaja.common.domain.Token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TokensRepository extends JpaRepository<Token, Long>, JpaSpecificationExecutor<Token> {

}
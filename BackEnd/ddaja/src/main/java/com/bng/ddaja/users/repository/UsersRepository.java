package com.bng.ddaja.users.repository;

import com.bng.ddaja.common.domain.Token;
import com.bng.ddaja.common.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsersRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    public User findById(long id);
    public User findByTokenOAuth(String tokenOAuth);
}
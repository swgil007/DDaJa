package com.bng.ddaja.test.repository.user;

import com.bng.ddaja.common.domain.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(String id);
    public User findByTokenRefresh(String refresh);
}

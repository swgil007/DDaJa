package com.ddaja.repository.user;

import java.util.Optional;

import com.ddaja.domain.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    public User findById(String id);
}

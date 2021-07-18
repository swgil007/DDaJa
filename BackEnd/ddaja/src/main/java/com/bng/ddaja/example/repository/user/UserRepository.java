package com.bng.ddaja.example.repository.user;

import java.util.List;

import com.bng.ddaja.common.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(long id);

    public User findByUserId(String id);

    public List<User> findAll();
    
}
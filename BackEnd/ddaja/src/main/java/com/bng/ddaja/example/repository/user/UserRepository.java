package com.bng.ddaja.example.repository.user;

import java.util.List;

import com.bng.ddaja.common.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(String id);

    //public User findByUid(long uId);

    //public User findByEmail(String email);

    public List<User> findAll();

    //public User findByUId(long uId);

    public User findById(long Id);
    
}
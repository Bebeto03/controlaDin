package com.bebeto.controlaDin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebeto.controlaDin.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    
}
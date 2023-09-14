package com.jotad9.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotad9.crud.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

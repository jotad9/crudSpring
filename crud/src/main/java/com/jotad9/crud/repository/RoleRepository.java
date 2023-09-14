package com.jotad9.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotad9.crud.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

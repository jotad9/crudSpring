package com.jotad9.crud.service;

import java.util.List;

import com.jotad9.crud.dto.UserDto;
import com.jotad9.crud.model.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);
    boolean authenticate(String username, String password);
    List<UserDto> findAllUsers();
}

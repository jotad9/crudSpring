package com.jotad9.crud.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jotad9.crud.dto.UserDto;
import com.jotad9.crud.model.Role;
import com.jotad9.crud.model.User;
import com.jotad9.crud.repository.RoleRepository;
import com.jotad9.crud.repository.UserRepository;
import com.jotad9.crud.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository,
            RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        // encrypt the password once we integrate spring security
        // user.setPassword(userDto.getPassword());
        user.setPassword((userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    public boolean authenticate(String username, String password) {
        // Busca al usuario por su correo electrónico (username) en la base de datos
        User user = userRepository.findByEmail(username);

        // Verifica si se encontró un usuario con ese correo electrónico
        if (user != null) {
            // Compara la contraseña proporcionada con la contraseña almacenada (sin cifrar)
            if (password.equals(user.getPassword())) {
                // La autenticación es exitosa
                return true;
            }
        }

        // La autenticación falla
        return false;
    }

}

package com.example.cessca.Service.impl;

import com.example.cessca.Dto.UserDto;
import com.example.cessca.Dto.LoginDto;
import com.example.cessca.Entity.RolEntity;
import com.example.cessca.Entity.UserEntity;
import com.example.cessca.Repository.RolRepository;
import com.example.cessca.Repository.UserRepository;
import com.example.cessca.Response.LoginResponse;
import com.example.cessca.Service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class UserIMPL implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RolRepository rolRepository;

    @Override
    public String addUser(UserDto userDto) {

        RolEntity rolEntity = rolRepository.findById(userDto.getRolId())
                .orElseThrow(() -> new NoSuchElementException("No se encontro el rol con ID:" + userDto.getRolId()));
        var userEntity  =  UserEntity.builder()
                .Id(userDto.getUserId())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .password(this.passwordEncoder.encode(userDto.getPassword()))
                .rolId(rolEntity).build();
        userRepository.save(userEntity);
        return userEntity.getEmail();

    }

    @Override
    public String deleteUser(UserDto userDto) {
        UserEntity userEntity = userRepository.findById(userDto.getUserId()).
                orElseThrow(()-> new NoSuchElementException("No se encontro el usuario con el ID " + userDto.getUserId()));
        this.userRepository.deleteById(userEntity.getId());
        return userEntity.getName();
    }

    @Override
    public List<String> getAllNormsNames() {
        return userRepository.findAll().stream()
                .map(UserEntity::getName)
                .collect(Collectors.toList());
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        // Buscar empleado por correo electrónico
        UserEntity userEntity = userRepository.findByEmail(loginDto.getEmail());

        // Verificar si el empleado existe
        if (userEntity != null) {
            // Comparar la contraseña proporcionada con la contraseña almacenada
            if (passwordEncoder.matches(loginDto.getPassword(), userEntity.getPassword())) {
                // Las contraseñas coinciden, inicio de sesión exitoso
                return new LoginResponse("Inicio de sesión satisfactorio", true);
            } else {
                // La contraseña no coincide, inicio de sesión fallido
                return new LoginResponse("Verifique su contraseña", false);
            }
        } else {
            // El empleado no existe en la base de datos
            return new LoginResponse("El email proporcionado no está registrado", false);
        }
    }


}

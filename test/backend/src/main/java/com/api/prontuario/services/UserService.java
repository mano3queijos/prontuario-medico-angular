package com.api.prontuario.services;

import com.api.prontuario.dtos.CredentialsDto;
import com.api.prontuario.dtos.SignUpUserDto;
import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.entites.User;
import com.api.prontuario.enums.Role;
import com.api.prontuario.infra.exceptions.AppException;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.repositories.UserRepository;
import com.api.prontuario.validators.ValidarCamposNulos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    ValidarCamposNulos validar = new ValidarCamposNulos();


    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }


        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }



    public UserDto register(SignUpUserDto userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.login());

        if (optionalUser.isPresent()) {
            throw new AppException("Login já existente", HttpStatus.BAD_REQUEST);
        }
        List<String> invalidos = validar.validarCamposNulos(userDto);

        if (!invalidos.isEmpty()) {
            throw new AppException("Campos inválidos: " + String.join(", ", invalidos), HttpStatus.BAD_REQUEST);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate dataNascimento = LocalDate.parse(userDto.dataNascimento(), formatter);


        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));
        user.setRole(Role.ADMIN);
        User savedUser = userRepository.save(user);
//        user.setDataNascimento(dataNascimento);
        return userMapper.toUserDto(savedUser);
    }

    public User findByLogin(String id) {
        User user = userRepository.findByLogin(id)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return user;
    }

    public List<UserDto> findAlldUsers() {
        List<User> users = userRepository.findAll();
//acho que retorna uma liosta vazia se não encontrar ninguem
        return users.stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }



}
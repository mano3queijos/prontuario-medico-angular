package com.api.prontuario.controllers;

import com.api.prontuario.config.UserAuthenticationProvider;
import com.api.prontuario.dtos.SignUpUserDto;
import com.api.prontuario.entites.User;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.services.UserService;
import com.api.prontuario.dtos.CredentialsDto;
import com.api.prontuario.dtos.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpUserDto user) {


        UserDto createdUser = userService.register(user);
//        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
// acho que não vai precisar desse cara
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);

    }

    @GetMapping("/users")
    public  List<UserDto> usuario () {

        List<UserDto> users = userService.findAlldUsers();

        return ResponseEntity.ok(users).getBody();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UserDto> usuarioPorId (@PathVariable String id) {
        User user = userService.findByLogin(id);
        return ResponseEntity.ok(userMapper.toUserDto(user));
    }
}

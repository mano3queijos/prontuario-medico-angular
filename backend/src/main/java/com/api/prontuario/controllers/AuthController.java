package com.api.prontuario.controllers;

import com.api.prontuario.config.UserAuthenticationProvider;
import com.api.prontuario.dtos.CredentialsDto;
import com.api.prontuario.dtos.SignUpUserDto;
import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.entites.User;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.services.UserService;
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

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpUserDto user) {
        UserDto userDto = userService.register(user);

        userDto.setToken(userAuthenticationProvider.createToken(userDto));

        return ResponseEntity.created(URI.create("/users/" + userDto.getId())).body(userDto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Valid SignUpUserDto user) {
        UserDto userDto = userService.update(id, user);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }
    @GetMapping("/users")
    public List<UserDto> usuario() {
        List<UserDto> users = userService.findAlldUsers();
        return ResponseEntity.ok(users).getBody();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> usuarioPorId(@PathVariable Long id) {
        UserDto userDto = userService.findById(id);
        return ResponseEntity.ok(userDto);
    }


}

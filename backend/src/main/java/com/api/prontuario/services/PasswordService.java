package com.api.prontuario.services;

import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.infra.exceptions.AppException;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PasswordService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    public void changePassword(Long id, String newPassword, UserDto userDto) {


        userRepository.findById(id).map(user -> {

            return user.getPassword();
        }).orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
    }


}

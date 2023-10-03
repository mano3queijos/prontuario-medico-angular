package com.api.prontuario.services;

import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.entites.Medico;
import com.api.prontuario.infra.exceptions.AppException;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    private final UserMapper userMapper;

//    public MedicoDto findByLogin(String login) {
//        Medico medico = repository.findByLogin(login).orElseThrow(() -> new AppException("Unknown medico", HttpStatus.NOT_FOUND));
//        return userMapper.toMedicoDto(medico);
//    }

}

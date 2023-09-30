package com.api.prontuario.services;

import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.entites.Medico;
import com.api.prontuario.infra.exceptions.AppException;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MedicoService {

    private final MedicoRepository Repository;

    private final UserMapper userMapper;

    public MedicoDto findByLogin(String login) {
        Medico medico = Repository.findByLogin(login).orElseThrow(() -> new AppException("Unknown medico", HttpStatus.NOT_FOUND));
        return userMapper.toMedicoDto(medico);
    }

}

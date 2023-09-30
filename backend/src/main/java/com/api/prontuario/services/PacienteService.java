package com.api.prontuario.services;

import com.api.prontuario.dtos.PacienteDto;
import com.api.prontuario.dtos.SignUpDto;
import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.entites.Paciente;
import com.api.prontuario.entites.User;
import com.api.prontuario.exceptions.AppException;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository Repository;

    private final UserMapper userMapper;

    public PacienteDto findByCpf(String cpf) {
        Paciente paciente = Repository.findByCpf(cpf).orElseThrow(() -> new AppException("Unknown paciente", HttpStatus.NOT_FOUND));
        // Dúvida: creio que não precisa do throw aqui eu acho... mas não sei como dar handle caso não seja encontrado paciente, como proceder?
        return userMapper.toPacienteDto(paciente);
    }

    public PacienteDto register(PacienteDto pacienteDto) {
        Optional<Paciente> optionalPaciente = Repository.findByCpf(pacienteDto.cpf());

        if (optionalPaciente.isPresent()) {
            throw new AppException("Paciente already exists", HttpStatus.BAD_REQUEST);
        }

//        Paciente paciente = new Paciente(pacienteDto);
//
//        Paciente savedPaciente = Repository.save();

//        return userMapper.toUserDto(savedUser);
        return "IDK";
    }
}

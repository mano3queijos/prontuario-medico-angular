package com.api.prontuario.services;

import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.dtos.SignUpDto;
import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.dtos.MedicoDto;

import com.api.prontuario.entites.Medico;
import com.api.prontuario.entites.User;
import com.api.prontuario.infra.exceptions.AppException;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.repositories.MedicoRepository;
import com.api.prontuario.validators.ValidarCamposNulos;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MedicoService {


    ValidarCamposNulos validar = new ValidarCamposNulos();

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;
    @Autowired
    private MedicoRepository medicoRepository;

    public Medico buscarPorId(Long id) {
        return medicoRepository.getReferenceById(id);
    }

    public UserDto register(SignUpDto medicoDto) {
        Optional<Medico> optionalUser = medicoRepository.findByLogin(medicoDto.login());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        List<String> invalidos = validar.validarCamposNulos(medicoDto);

        if (!invalidos.isEmpty()) {
            throw new AppException("Campos inválidos: " + String.join(", ", invalidos), HttpStatus.BAD_REQUEST);
        }


        Medico medico = (Medico) userMapper.signUpToUser(medicoDto);
        medico.setPassword(passwordEncoder.encode(CharBuffer.wrap(medicoDto.password())));

        Medico saveMedico = medicoRepository.save(medico);

        return userMapper.toUserDto(saveMedico);
    }

    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }

//    public MedicoDto findByLogin(String login) {
//        Medico medico = repository.findByLogin(login).orElseThrow(() -> new AppException("Unknown medico", HttpStatus.NOT_FOUND));
//        return userMapper.toMedicoDto(medico);
//    }

}

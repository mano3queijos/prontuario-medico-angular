package com.api.prontuario.services;

import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.dtos.SignUpUserDto;
import com.api.prontuario.dtos.SingUpMedicoDto;
import com.api.prontuario.dtos.UserDto;

import com.api.prontuario.entites.Medico;
import com.api.prontuario.entites.User;
import com.api.prontuario.enums.Role;
import com.api.prontuario.infra.exceptions.AppException;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.repositories.MedicoRepository;
import com.api.prontuario.validators.ValidarCamposNulos;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MedicoService {


    ValidarCamposNulos validar = new ValidarCamposNulos();

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;
    private final MedicoRepository medicoRepository;

    public Medico buscarPorId(Long id) {
        return medicoRepository.getReferenceById(id);
    }

    public MedicoDto register(SingUpMedicoDto medicoDto) {
        Optional<Medico> optionalUser = medicoRepository.findByLogin(medicoDto.login());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        List<String> invalidos = validar.validarCamposNulos(medicoDto);

        if (!invalidos.isEmpty()) {
            throw new AppException("Campos inválidos: " + String.join(", ", invalidos), HttpStatus.BAD_REQUEST);
        }


        Medico medico =  userMapper.signUpToMedico(medicoDto);
        medico.setPassword(passwordEncoder.encode(CharBuffer.wrap(medicoDto.password())));
        medico.setRole(Role.MEDICO);
        medico.setCrm(medicoDto.crm());
        medico.setEspecialidade(medicoDto.especialidade());
        Medico saveMedico = medicoRepository.save(medico);


        return userMapper.toMedicoDto(saveMedico);
    }

    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }




    public List<MedicoDto> findAllMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
//acho que retorna uma liosta vazia se não encontrar ninguem
        return medicos.stream()
                .map(userMapper::toMedicoDto)
                .collect(Collectors.toList());
    }


//    public MedicoDto findByLogin(String login) {
//        Medico medico = repository.findByLogin(login).orElseThrow(() -> new AppException("Unknown medico", HttpStatus.NOT_FOUND));
//        return userMapper.toMedicoDto(medico);
//    }

}

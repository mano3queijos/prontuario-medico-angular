package com.api.prontuario.services;

import com.api.prontuario.dtos.PacienteDto;
import com.api.prontuario.entites.Paciente;
import com.api.prontuario.infra.exceptions.AppException;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    private final UserMapper userMapper;

    public PacienteDto findByPaciente(Paciente paciente) {
        Paciente paciente1 = pacienteRepository.findByCpf(paciente.getCpf()).orElseThrow(() -> new AppException("Unknown paciente", HttpStatus.NOT_FOUND));
        // Dúvida: creio que não precisa do throw aqui eu acho... mas não sei como dar handle caso não seja encontrado paciente, como proceder?
        // Da pra fazer tipo um tratador de erros, se liga vou tentar fazer... edit2: adicionei lá na infra.exceptions
        return userMapper.toPacienteDto(paciente);
    }

    public Paciente register(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.getReferenceById(id);
    }

    public Page<Paciente> listarTodos(Pageable paginacao) {
        return pacienteRepository.findAll(paginacao);
    }

    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }

//    public Paciente atualizar(Paciente paciente) {
//
//    }
}

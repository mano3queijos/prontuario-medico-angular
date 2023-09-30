package com.api.prontuario.dtos;

import com.api.prontuario.entites.Paciente;
import com.api.prontuario.entites.RegistroMedico;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.repositories.PacienteRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record PacienteDto(@Valid @NotNull FichaCadastralDto fichaCadastralDto, @NotNull String nome, @NotNull @Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$") String cpf,
                          @NotNull Date dataNasc, @Valid EnderecoDto enderecoDto,
                          String telefone, @NotNull String raca, @NotNull Double peso, @NotNull String curso,
                          @NotNull Integer altura, @NotNull String email, @Valid @NotNull RegistroMedicoDto registroMedicoDto) {
    private static UserMapper userMapper;
    public PacienteDto(Paciente paciente) {
        this(userMapper.toFichaCadastralDto(paciente.getFichaCadastral()), paciente.getNome(), paciente.getCpf(),
                paciente.getDataNasc(), userMapper.toEnderecoDto(paciente.getEndereco()), paciente.getTelefone(),
                paciente.getRaca(), paciente.getPeso(), paciente.getCurso(),
                paciente.getAltura(), paciente.getEmail(), userMapper.toRegistroMedicoDto(paciente.getRegistroMedico()));
    }
}



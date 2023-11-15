package com.api.prontuario.dtos;

import com.api.prontuario.enums.Role;
import com.api.prontuario.validators.Validacao;


public record SignUpUserDto(
        @Validacao(descricao = "CPF não pode ser nulo") String cpf,
        @Validacao(descricao = "Nome não pode ser nulo") String nome,

        Role role,

        @Validacao(descricao = "Telefone não pode ser nulo") String telefone,
        @Validacao(descricao = "Login não pode ser nulo") String login,
        @Validacao(descricao = "Senha não pode ser nula") String password
) { }

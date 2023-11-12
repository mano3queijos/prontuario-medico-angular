package com.api.prontuario.dtos;

import com.api.prontuario.validators.Validacao;

public record SingUpMedicoDto(@Validacao(descricao = "CPF não pode ser nulo") String cpf,
                              @Validacao(descricao = "Nome não pode ser nulo") String nome,
                              @Validacao(descricao = "Telefone não pode ser nulo") String telefone,
                              @Validacao(descricao = "Login não pode ser nulo") String login,
                              @Validacao(descricao = "O campo de crm não pode estar nulo") String crm,

//                              @Validacao(descricao = "data de nascimento não pode ser nula") String dataNascimento,

                              @Validacao(descricao = "o campo de especialidade não pode estar nulo") String especialidade,

                              @Validacao(descricao = "Senha não pode ser nula") String password) {

}

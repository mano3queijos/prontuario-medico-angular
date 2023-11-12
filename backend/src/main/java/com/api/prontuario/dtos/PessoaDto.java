package com.api.prontuario.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PessoaDto {

    private Long id;
    private String cpf;

    private String nome;

    private Date dataNascimento;

    private String telefone;


}

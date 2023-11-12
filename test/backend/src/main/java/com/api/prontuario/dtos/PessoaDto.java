package com.api.prontuario.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PessoaDto {

    private Long id;
    private String cpf;

    private String nome;

//    private LocalDate dataNascimento;

    private String telefone;


}

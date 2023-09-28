package com.api.prontuario.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicoDto {
    private String nome;
    private String crm;
    private String especialidade;
    private String cpf;
    private Date dataNasc;
}

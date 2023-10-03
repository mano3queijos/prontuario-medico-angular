package com.api.prontuario.dtos;

import com.api.prontuario.entites.Medico;
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

    public MedicoDto(Medico medico) {
    }
}

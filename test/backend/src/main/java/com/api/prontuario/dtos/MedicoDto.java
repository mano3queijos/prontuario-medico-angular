package com.api.prontuario.dtos;

import com.api.prontuario.entites.Medico;
import com.api.prontuario.enums.Role;
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
public class MedicoDto extends UserDto{
    private String crm;
    private String especialidade;

}

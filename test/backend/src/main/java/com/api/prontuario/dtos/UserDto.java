package com.api.prontuario.dtos;

import com.api.prontuario.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDto extends PessoaDto {

    private Role role;
    private String login;
    private String token;

}

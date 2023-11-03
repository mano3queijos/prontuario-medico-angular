package com.api.prontuario.dtos;

import com.api.prontuario.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private Role role;
    private String nome;
    private String login;
    private String token;

}

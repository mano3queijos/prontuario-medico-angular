package com.api.prontuario.mappers;

import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.dtos.PacienteDto;
import com.api.prontuario.dtos.SignUpDto;
import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.entites.Medico;
import com.api.prontuario.entites.Paciente;
import com.api.prontuario.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);
    MedicoDto toMedicoDto(Medico medico);
    PacienteDto toPacienteDto(Paciente paciente);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}

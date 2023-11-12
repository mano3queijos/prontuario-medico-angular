package com.api.prontuario.mappers;

import com.api.prontuario.dtos.*;
import com.api.prontuario.entites.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);
    MedicoDto toMedicoDto(Medico medico);
    FichaCadastralDto toFichaCadastralDto(FichaCadastral fichaCadastral);
    RegistroMedicoDto toRegistroMedicoDto(RegistroMedico registroMedico);
    EnderecoDto toEnderecoDto(Endereco endereco);

    PacienteDto toPacienteDto(Paciente paciente);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpUserDto signUpUserDto);
    Medico signUpToMedico(SingUpMedicoDto singUpMedicoDto);

}

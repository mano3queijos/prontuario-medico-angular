package com.api.prontuario.mappers;

import com.api.prontuario.dtos.SignUpDto;
import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}

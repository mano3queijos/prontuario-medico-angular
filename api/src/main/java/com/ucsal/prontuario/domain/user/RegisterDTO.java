package com.ucsal.prontuario.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}

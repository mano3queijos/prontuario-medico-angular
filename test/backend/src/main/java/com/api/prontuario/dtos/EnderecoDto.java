package com.api.prontuario.dtos;

import com.api.prontuario.entites.Endereco;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.List;

public record EnderecoDto( @NotNull @Pattern(regexp = "\\d{8}") String cep , String complemento,
                           @NotNull String logradouro, String numero, @NotNull String bairro,
                           @NotNull String cidade, @NotNull String estado, @NotNull String pais) {}
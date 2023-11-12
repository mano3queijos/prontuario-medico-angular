package com.api.prontuario.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Long id;
    private String cpf;
    private String nome;
//    private LocalDate dataNascimento;
    private String telefone;


}

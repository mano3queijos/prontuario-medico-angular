package com.api.prontuario.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
}

package com.api.prontuario.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Medico extends User {
    private String crm;
    private String especialidade;
}

package com.api.prontuario.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "procedimento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Procedimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long nome;
    private String descricao;
    //private Medico medico;
    private LocalDateTime diaHorario;

}

package com.api.prontuario.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long nome;
    private String contraIndicacao;
    //private Medico medico;
    private List<String> frequencia = new ArrayList<>();
    private boolean emUso;

}

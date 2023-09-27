package com.api.prontuario.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String queixa;
    private String anamnese;
    private String exameFisico;
    private String pressaoArterial;
    private String frequenciaCardiaca;
    private String frequenciaRespiratoria;
    private String temperatura;
    private String dor;
    private String saturacao;
    private String glicemiaCapilar;
    private List<String> comorbidades;
}

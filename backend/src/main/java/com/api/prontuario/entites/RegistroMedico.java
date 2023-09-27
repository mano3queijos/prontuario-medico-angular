package com.api.prontuario.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RegistroMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Paciente paciente;
    private List<Medicamento> medicamentosEmuso = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();
    private List<Exame> exames = new ArrayList<>();
    private List<Procedimento> procedimentos = new ArrayList<>();
    private List<Historico> historicoList;

}

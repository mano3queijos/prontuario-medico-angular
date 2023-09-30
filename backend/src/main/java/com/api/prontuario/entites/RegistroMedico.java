package com.api.prontuario.entites;

import com.api.prontuario.dtos.RegistroMedicoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "registromedico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RegistroMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @OneToOne(mappedBy = "registromedico") é pra ser paciente
//    private FichaCadastral fichaCadastral; nao ficha cadastral
    private List<Medicamento> medicamentos = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();
    private List<Exame> exames = new ArrayList<>();
    private List<Procedimento> procedimentos = new ArrayList<>();
    private List<Historico> historicoList = new ArrayList<>();

    public RegistroMedico(RegistroMedicoDto registroMedicoDto) {
        this.medicamentos = medicamentos;
        this.consultas = consultas;
        this.exames = exames;
        this.procedimentos = procedimentos;
        this.historicoList = historicoList;
    }
}

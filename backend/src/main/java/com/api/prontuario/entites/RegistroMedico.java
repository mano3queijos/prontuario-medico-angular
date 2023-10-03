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
    @OneToMany
    @JoinColumn(name = "medicamento_id")
    private List<Medicamento> medicamentos = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "consulta_id")
    private List<Consulta> consultas = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "exame_id")
    private List<Exame> exames = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "procedimento_id")
    private List<Procedimento> procedimentos = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "historico_id")
    private List<Historico> historicoList = new ArrayList<>();

    public RegistroMedico(RegistroMedicoDto registroMedicoDto) {
        this.medicamentos = medicamentos;
        this.consultas = consultas;
        this.exames = exames;
        this.procedimentos = procedimentos;
        this.historicoList = historicoList;
    }
}

package com.api.prontuario.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String queixa;
    private String anamnese;
    @Column(name = "exame_fisico")
    private String exameFisico;
    @Column(name = "pressao_arterial")
    private String pressaoArterial;
    @Column(name = "frequencia_cardíaca")
    private String frequenciaCardiaca;
    @Column(name = "frequencia_respiratoria")
    private String frequenciaRespiratoria;
    private String temperatura;
    private String dor;
    private String saturacao;
    @Column(name = "glicemia_capilar")
    private String glicemiaCapilar;

    @ElementCollection
    @CollectionTable(name = "comorbidade", joinColumns = @JoinColumn(name = "paciente_id"))
    private List<String> comorbidades;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registro_medico_id", referencedColumnName = "id")
    private RegistroMedico registroMedico;
}

package com.api.prontuario.entites;

import com.api.prontuario.dtos.FichaCadastralDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "ficha_cadastral")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FichaCadastral {
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
    private String curso;
    @Column(name = "glicemia_capilar")
    private String glicemiaCapilar;
    @ElementCollection
    @CollectionTable(name = "comorbidade", joinColumns = @JoinColumn(name = "paciente_id"))
    private List<String> comorbidades;

    @OneToOne(mappedBy = "ficha_cadastral")
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    public FichaCadastral(FichaCadastralDto fichaCadastralDto) {
        this.queixa = fichaCadastralDto.queixa();
        this.anamnese = fichaCadastralDto.anamnese();
        this.exameFisico = fichaCadastralDto.exameFisico();
        this.pressaoArterial = fichaCadastralDto.pressao();
        this.frequenciaCardiaca = fichaCadastralDto.freqCardiaca();
        this.frequenciaRespiratoria = fichaCadastralDto.freqRespiratoria();
        this.temperatura = fichaCadastralDto.temperatura();
        this.dor = fichaCadastralDto.dor();
        this.saturacao = fichaCadastralDto.saturacao();
        this.glicemiaCapilar = fichaCadastralDto.glicemiaCapilar();
        this.comorbidades = fichaCadastralDto.comorbidades();
    }
}

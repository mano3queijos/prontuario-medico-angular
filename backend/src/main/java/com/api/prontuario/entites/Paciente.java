package com.api.prontuario.entites;


import java.util.List;

public class Paciente extends Pessoa {
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

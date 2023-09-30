package com.api.prontuario.dtos;

import java.util.Date;
import java.util.List;

public record PacienteDto(String nome, String cpf, Date dataNasc,
                          String telefone, String raca, String curso,
                          String colaborador, String externo, Double peso,
                          Integer altura, String email, String cep, String complemento,
                          String logradouro, String numero, String bairro,
                          String cidade, String estado, String pais,
                          List<String> alergias, boolean isExterno, String queixa,
                          String anamnese, String exameFisico, String pressaoArterial,
                          String frequenciaCardiaca, String frequenciaRespiratoria,
                          String temperatura, String dor, String saturacao,
                          String glicemiaCapilar, List<String> comorbidades) {}

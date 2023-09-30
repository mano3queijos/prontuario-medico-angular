package com.api.prontuario.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FichaCadastralDto(@NotNull List<String> alergias, boolean isExterno,
                                @NotNull String temperatura, @NotNull String anamnese, @NotNull String queixa,
                                @NotNull String med, @NotNull String medEmUso, @NotNull String exameFisico,
                                @NotNull String pressao, @NotNull String freqRespiratoria, @NotNull String freqCardiaca,
                                @NotNull String dor, @NotNull String saturacao, @NotNull String glicemiaCapilar,
                                List<String> comorbidades) {}

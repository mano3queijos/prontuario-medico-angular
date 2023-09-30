package com.api.prontuario.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record RegistroMedicoDto(@NotNull @Valid MedicamentoDto medicamentoDto, @NotNull @Valid ConsultaDto consultaDto,
                                @NotNull @Valid ExameDto exameDto, @NotNull @Valid ProcedimentoDto procedimentoDto,
                                @NotNull @Valid HistoricoDto historicoDto) {}
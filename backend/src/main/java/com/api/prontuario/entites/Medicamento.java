package com.api.prontuario.entites;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Medicamento {
    private Long id;
    private Long nome;
    private String contraIndicacao;
    private Paciente paciente;
    //private Medico medico;
    private List<String> frequencia = new ArrayList<>();

}

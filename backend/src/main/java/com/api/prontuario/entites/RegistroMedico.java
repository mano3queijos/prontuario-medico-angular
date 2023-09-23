package com.api.prontuario.entites;

import java.util.ArrayList;
import java.util.List;


public class RegistroMedico {
    private Long id;

    private List<Medicamento> medicamentosEmuso = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();
    private List<Exame> exames = new ArrayList<>();
    private List<Procedimento> procedimentos = new ArrayList<>();
    private List<Historico> historicoList;

}

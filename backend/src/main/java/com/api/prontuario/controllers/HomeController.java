package com.api.prontuario.controllers;

import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.dtos.FichaCadastralDto;
import com.api.prontuario.dtos.PacienteDto;
import com.api.prontuario.entites.FichaCadastral;
import com.api.prontuario.entites.Paciente;
import com.api.prontuario.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    private final MedicoService medicoService;
    public HomeController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/dadosbase")
    public ResponseEntity<MedicoDto> DadosBase(String login) {
        var medico = medicoService.findByLogin(login);
        return ResponseEntity.ok(medico);
    }

    @GetMapping("/paciente")
    public ResponseEntity<PacienteDto> CadastrarPaciente(@RequestBody @Valid PacienteDto pacienteDto) {
        Paciente paciente = new Paciente(pacienteDto);
        return new ResponseEntity<>(new PacienteDto(paciente), HttpStatus.CREATED);
    }
}

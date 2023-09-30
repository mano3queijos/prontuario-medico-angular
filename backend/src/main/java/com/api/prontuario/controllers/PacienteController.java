package com.api.prontuario.controllers;

import com.api.prontuario.dtos.PacienteDto;
import com.api.prontuario.entites.Paciente;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {


    @GetMapping("/paciente")
    public ResponseEntity<PacienteDto> CadastrarPaciente(@RequestBody @Valid PacienteDto pacienteDto) {
        Paciente paciente = new Paciente(pacienteDto);
        return new ResponseEntity<>(new PacienteDto(paciente), HttpStatus.CREATED);
    }
}

package com.api.prontuario.controllers;

import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.dtos.PacienteDto;
import com.api.prontuario.dtos.SignUpDto;
import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.services.MedicoService;
import com.api.prontuario.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class HomeController {

    private final MedicoService medicoService;
    public HomeController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/DadosBase")
    public ResponseEntity<MedicoDto> DadosBase(String login) {
        var medico = medicoService.findByLogin(login);
        return ResponseEntity.ok(medico);
    }

    @GetMapping("/Paciente")
    public ResponseEntity<MedicoDto> CadastrarPaciente(@RequestBody @Valid PacienteDto paciente) {
//        PacienteDto createdPaciente = PacienteService.register(user);
//        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
//        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
        return "I want to die";
    }
}

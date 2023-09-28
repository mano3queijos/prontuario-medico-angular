package com.api.prontuario.controllers;

import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

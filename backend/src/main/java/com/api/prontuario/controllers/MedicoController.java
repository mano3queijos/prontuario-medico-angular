package com.api.prontuario.controllers;

import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.dtos.PacienteDto;
import com.api.prontuario.dtos.SignUpDto;
import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    private UserMapper userMapper;

    @GetMapping("/dadosbase/{id}")
    public ResponseEntity<MedicoDto> buscarPorId(Long id) {
        var medico = medicoService.buscarPorId(id);
        return ResponseEntity.ok((userMapper.toMedicoDto(medico)));
    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<MedicoDto> deletarMedicoPorId(@PathVariable Long id) {
        medicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


//    ajeitar
    @PostMapping("/register")
    public ResponseEntity<MedicoDto> register(@RequestBody @Valid SignUpDto medico) {
        MedicoDto createdMedico = medicoService.register(medico);
        createdMedico.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }


}

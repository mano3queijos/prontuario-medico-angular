package com.api.prontuario.controllers;

import com.api.prontuario.config.UserAuthenticationProvider;
import com.api.prontuario.dtos.MedicoDto;
import com.api.prontuario.dtos.SignUpUserDto;
import com.api.prontuario.dtos.SingUpMedicoDto;
import com.api.prontuario.dtos.UserDto;
import com.api.prontuario.mappers.UserMapper;
import com.api.prontuario.services.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;
    private final  UserAuthenticationProvider userAuthenticationProvider;
    private final UserMapper userMapper;


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


    @GetMapping("/medicos")
    public List<MedicoDto> usuario () {

        List<MedicoDto> medicos = medicoService.findAllMedicos();

        return ResponseEntity.ok(medicos).getBody();
    }



    @PostMapping("/register")
    public ResponseEntity<MedicoDto> register(@RequestBody @Valid SingUpMedicoDto medico) {
        MedicoDto medicoDto = medicoService.register(medico);
        medicoDto.setToken(userAuthenticationProvider.createToken(medicoDto));
        return ResponseEntity.created(URI.create("/medicos/" + medicoDto.getId())).body(medicoDto);
    }


}

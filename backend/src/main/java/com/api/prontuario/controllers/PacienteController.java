package com.api.prontuario.controllers;

import com.api.prontuario.dtos.PacienteDto;
import com.api.prontuario.entites.Paciente;
import com.api.prontuario.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<Page<PacienteDto>> buscarTodos (@PageableDefault(size = 10) Pageable paginacao) {
        var page = pacienteService.listarTodos(paginacao).map(PacienteDto::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> buscarPorId (@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPorId(id);
        return ResponseEntity.ok(new PacienteDto(paciente));
    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<PacienteDto> cadastrarPaciente(@RequestBody @Valid PacienteDto pacienteDto) {
        Paciente paciente = pacienteService.register(new Paciente(pacienteDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(new PacienteDto(paciente));
    }


//    @PutMapping("/atualizar/{id}")
//    @Transactional
//    public ResponseEntity<PacienteDto> atualizar(@RequestBody @Valid PacienteDto pacienteDto, @PathVariable Long id){
//        var paciente = pacienteService.buscarPorId(id);
//        pacienteService.atualizar(paciente);
//
//        return ResponseEntity.ok(new PacienteDto(paciente));
//    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<PacienteDto> deletarPacientePorId(@PathVariable Long id) {
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

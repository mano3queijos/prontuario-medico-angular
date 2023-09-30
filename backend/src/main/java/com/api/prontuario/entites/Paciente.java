package com.api.prontuario.entites;

import com.api.prontuario.dtos.FichaCadastralDto;
import com.api.prontuario.dtos.PacienteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ficha_cadastral_id", referencedColumnName = "id")
    private FichaCadastral fichaCadastral;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registro_medico_id", referencedColumnName = "id")
    private RegistroMedico registroMedico;
    private String curso;

    public Paciente(PacienteDto pacienteDto) {
        this.fichaCadastral = new FichaCadastral(pacienteDto.fichaCadastralDto());
        this.registroMedico = new RegistroMedico(pacienteDto.registroMedicoDto());
        this.curso = pacienteDto.curso();
    }
}


import { Component, OnInit } from '@angular/core';
import { Paciente } from '../paciente/shared/paciente';
import { PacienteService } from '../paciente.service';
import { Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { data } from 'jquery';

export class AppModule {}



@Component({
  
  selector: 'app-cadastro-paciente',
  templateUrl: './cadastro-paciente.component.html',
  styleUrls: ['./cadastro-paciente.component.css']
})


export class CadastroPacienteComponent implements OnInit {



  
 novoPaciente: Paciente = {
    id: 0, 
    nome: '',
    dataNascimento: new Date(),
    raca: '',
    peso: 0,
    altura: 0,
    curso: '',
    colaborador: false,
    externo: false,
    endereco: '',
    telefone: '',
    email: '',
    queixaHistoriaMolesia: '',
    anamnese: '',
    alergias: false,
    quaisAlergias: '',
    medicamento: '',
    exameFisico: {
      pressaoArterial: '',
      frequenciaRespiratoria: 0,
      frequenciaCardiaca: 0,
      temperatura: 0,
      dor: '',
      saturacao: 0,
      glicemiaCapilar: 0,
    },
    comorbidades: [],
    medicacaoEmUso: [],
    evolucaoEnfermagem: '',
  };
  submitted = false;





  

  constructor(private pacienteService: PacienteService) {
  }

  ngOnInit(): void{  }

savePaciente(): void {
  console.log("qdfojqwe´0f0=")
  const pacienteData = {
    nome: this.novoPaciente.nome,
    dataNascimento: this.novoPaciente.dataNascimento,
    raca: this.novoPaciente.raca,
    peso: this.novoPaciente.peso,
    altura: this.novoPaciente.altura,
    curso: this.novoPaciente.curso,
    colaborador: this.novoPaciente.colaborador,
    externo: this.novoPaciente.externo,
    endereco: this.novoPaciente.endereco,
    telefone: this.novoPaciente.telefone,
    email: this.novoPaciente.email,
    queixaHistoriaMolesia: this.novoPaciente.queixaHistoriaMolesia,
    anamnese: this.novoPaciente.anamnese,
    alergias: this.novoPaciente.alergias,
    quaisAlergias: this.novoPaciente.quaisAlergias,
    medicamento: this.novoPaciente.medicamento,
    exameFisico: {
      pressaoArterial: this.novoPaciente.exameFisico.pressaoArterial,
      frequenciaRespiratoria: this.novoPaciente.exameFisico.frequenciaRespiratoria,
      frequenciaCardiaca: this.novoPaciente.exameFisico.frequenciaCardiaca,
      temperatura: this.novoPaciente.exameFisico.temperatura,
      dor: this.novoPaciente.exameFisico.dor,
      saturacao: this.novoPaciente.exameFisico.saturacao,
      glicemiaCapilar: this.novoPaciente.exameFisico.glicemiaCapilar,
    },
    comorbidades: [...this.novoPaciente.comorbidades],
    medicacaoEmUso: [...this.novoPaciente.medicacaoEmUso],
    evolucaoEnfermagem: this.novoPaciente.evolucaoEnfermagem,
  };

      this.pacienteService.create(pacienteData)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });


}

  newPaciente(): void {
    this.submitted = false;
    this.novoPaciente = {

      id: 0, 
    nome: '',
    dataNascimento: new Date(),
    raca: '',
    peso: 0,
    altura: 0,
    curso: '',
    colaborador: false,
    externo: false,
    endereco: '',
    telefone: '',
    email: '',
    queixaHistoriaMolesia: '',
    anamnese: '',
    alergias: false,
    quaisAlergias: '',
    medicamento: '',
    exameFisico: {
      pressaoArterial: '',
      frequenciaRespiratoria: 0,
      frequenciaCardiaca: 0,
      temperatura: 0,
      dor: '',
      saturacao: 0,
      glicemiaCapilar: 0,
    },
    comorbidades: [],
    medicacaoEmUso: [],
    evolucaoEnfermagem: '',

    };
  }

}
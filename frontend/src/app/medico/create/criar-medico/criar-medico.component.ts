import { Component } from '@angular/core';
import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';
import { Medico } from '../../../shared/model/medico';
import { FormBuilder } from '@angular/forms';
import { __param } from 'tslib';
import { MedicoService } from '../../medico.service';
import { Router } from 'express';

library.add(fas);

@Component({
  selector: 'app-criar-medico',
  templateUrl: './criar-medico.component.html',
  styleUrls: ['./criar-medico.component.scss'],

})
export class CriarMedicoComponent {
  constructor(private medicoService: MedicoService) { }


  medico: Medico = {
    cpf: '',
    nome: '',
    dataNascimento: new Date,
    telefone: '',
    role: '',
    login: '',
    password: '',
    crm: '',
    especialidade: '',
    id: 0,
  }



  createMedico() {
    this.medicoService.registerMedicos(this.medico);
  }



}

import { Component } from '@angular/core';
import{ Paciente } from '../paciente.service'
import{ PacienteService} from '../paciente.service'

@Component({
  selector: 'app-cadastro-paciente',
  templateUrl: './cadastro-paciente.component.html',
  styleUrls: ['./cadastro-paciente.component.css']
})
export class CadastroPacienteComponent {



 novoPaciente: Paciente = {
    id: 0, // Defina o valor adequado para o ID, se necessário
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
   constructor(private pacienteService: PacienteService) {}
    salvarPaciente(): void {this.pacienteService.createPaciente(this.novoPaciente);

  }

}

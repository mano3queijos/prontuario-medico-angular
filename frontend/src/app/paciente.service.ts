import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  private pacientes: Paciente[] = [];

  createPaciente(paciente: Paciente): void {
    this.pacientes.push(paciente);
  }

  getPacientes(): Paciente[] {
    return this.pacientes;
  }

  updatePaciente(id: number, updatedPaciente: Paciente): void {
    const index = this.pacientes.findIndex(p => p.id === id);
    if (index !== -1) {
      this.pacientes[index] = updatedPaciente;
    }
  }

  deletePaciente(id: number): void {
    const index = this.pacientes.findIndex(p => p.id === id);
    if (index !== -1) {
      this.pacientes.splice(index, 1);
    }
  }
}

export interface Paciente {
  id: number;

  nome: string;
  dataNascimento: Date; // Data de Nascimento no formato "dd/mm/yyyy"
  raca: string;
  peso: number;
  altura: number;
  curso: string;
  colaborador: boolean;
  externo: boolean;
  endereco: string;
  telefone: string; // Telefone no formato "(00) 99999-9999"
  email: string;
  queixaHistoriaMolesia: string;
  anamnese: string;
  alergias: boolean;
  quaisAlergias?: string; // Somente se alergias for verdadeiro (boolean)
  medicamento: string;
  exameFisico: {
    pressaoArterial: string; // Exemplo: "120/80"
    frequenciaRespiratoria: number;
    frequenciaCardiaca: number;
    temperatura: number;
    dor: string;
    saturacao: number;
    glicemiaCapilar: number;
  };
  comorbidades: string[];
  medicacaoEmUso: string[];
  evolucaoEnfermagem: string;
}


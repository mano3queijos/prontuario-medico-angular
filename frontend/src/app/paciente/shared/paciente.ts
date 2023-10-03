export interface ExameFisico {
  pressaoArterial: string;
  frequenciaRespiratoria: number;
  frequenciaCardiaca: number;
  temperatura: number;
  dor: string;
  saturacao: number;
  glicemiaCapilar: number;
}

export class Paciente {
  id: number = 0;
  nome: string = '';
  dataNascimento: Date = new Date();
  raca: string = '';
  peso: number = 0;
  altura: number = 0;
  curso: string = '';
  colaborador: boolean = false;
  externo: boolean = false;
  endereco: string = '';
  telefone: string = '';
  email: string = '';
  queixaHistoriaMolesia: string = '';
  anamnese: string = '';
  alergias: boolean = false;
  quaisAlergias: string = '';
  medicamento: string = '';
  exameFisico: ExameFisico = {
    pressaoArterial: '',
    frequenciaRespiratoria: 0,
    frequenciaCardiaca: 0,
    temperatura: 0,
    dor: '',
    saturacao: 0,
    glicemiaCapilar: 0,
  };
  comorbidades: string[] = [];
  medicacaoEmUso: string[] = [];
  evolucaoEnfermagem: string = '';


  
}

import { User } from "./user";

export class Medico extends User {
  crm: string;
  especialidade: string;


  constructor(cpf: string, nome: string, dataNascimento: Date, telefone: string, role: string, login: string, password: string, crm: string, especialidade: string, id: number) {
    super(cpf, nome, dataNascimento, telefone, role, login, password, id);
    this.crm = crm;
    this.especialidade = especialidade;
  }

}

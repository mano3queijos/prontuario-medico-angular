export class Pessoa {
  cpf: string;
  nome: string;
  dataNascimento: Date;
  telefone: string;
  id: number;

  constructor(cpf: string, nome: string, dataNascimento: Date, telefone: string, id: number) {
    this.cpf = cpf;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.telefone = telefone;
    this.id = id;
  }
}



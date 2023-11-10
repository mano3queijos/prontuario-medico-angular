export class Pessoa {
  cpf: string;
  nome: string;
  dataNascimento: Date;
  telefone: string;

  constructor(cpf: string, nome: string, dataNascimento: Date, telefone: string) {
    this.cpf = cpf;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.telefone = telefone;
  }
}



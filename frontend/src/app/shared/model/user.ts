import { Pessoa } from "./pessoa";

export class User extends Pessoa {

  role: string;
  login: string;
  password: string;

  constructor(cpf: string, nome: string, dataNascimento: Date, telefone: string, role: string, login: string, password: string, id: number) {
    super(cpf, nome, dataNascimento, telefone, id);
    this.role = role;
    this.login = login;
    this.password = password;
  }
}

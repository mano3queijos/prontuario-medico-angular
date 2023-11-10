import { Pessoa } from "./pessoa";

export class User extends Pessoa {

  role: string;
  login: string;
  password: string;

  constructor(cpf: string, nome: string, dataNascimento: Date, telefone: string, role: string, login: string, password: string) {
    super(cpf, nome, dataNascimento, telefone);
    this.role = role;
    this.login = login;
    this.password = password;
  }
}

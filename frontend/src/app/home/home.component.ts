import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  nomeDoUsuario: string = 'Null';
    consultas: any[] = [];

  dataHoraAtual: string = ''; 
   dataDoDia: string = '';

  constructor(private axiosService: AxiosService) {}

  ngOnInit() {
    this.atualizarDataHora(); 

    this.obterNomeDoUsuario();

    setInterval(() => this.atualizarDataHora(), 1000); 
  }

atualizarDataHora() {
  const dataAtual = new Date();
      this.dataHoraAtual = dataAtual.toLocaleString(); 
  const options: Intl.DateTimeFormatOptions = {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
  };
  this.dataDoDia = dataAtual.toLocaleDateString('pt-BR', options);
}


    obterNomeDoUsuario() {
    this.axiosService.request('GET', '/api/usuario', null).then((response) => {
      this.nomeDoUsuario = response.data.nome;
    }).catch((error) => {
      console.error('Erro ao obter informações do usuário:', error);
    });
  }

  obterConsultasDoDia(){

const usuarioId = 1; // pegar o id pelo token
    const dataEspecifica = this.dataDoDia;

    this.axiosService.request('GET', `/api/consultas/${usuarioId}?data=${this.dataDoDia}`, null).then((response)=>{
      this.consultas = response.data;
    }).catch((error) => {
      console.error('Erro ao obter consultas:', error);
    });

  }
}

//ajeitar mais tarde
interface Consulta {
  id: number;
  nomeMedico: string;
  nomePaciente: string;
  horario: string;
  imagemMedico: string; // URL da imagem do médico
}
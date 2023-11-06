import { Component, Input } from '@angular/core';
import { AxiosService } from '../axios.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  @Input() adm: string = '../assets/images/adm.png'

  constructor(private AxiosService: AxiosService) { }



  dataHora: string = '';
  dataDoDia: string = '';

  ngOnInit() {
    this.atualizarDataHora();
    setInterval(() => this.atualizarDataHora(), 1000);

  }

  atualizarDataHora() {
    const dataAtual = new Date();
    this.dataHora = dataAtual.toLocaleString();
    const options: Intl.DateTimeFormatOptions = {
      year: 'numeric',
      month: '2-digit',
      day: '2-digit',
    };
    this.dataDoDia = dataAtual.toLocaleDateString('pt-BR', options);
  }


  getNome(): string | undefined {
    const role = this.AxiosService.getRole();
    return role?.username.toUpperCase();
  }




}

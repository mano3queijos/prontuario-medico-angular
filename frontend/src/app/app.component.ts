import { Component, Input } from '@angular/core';
import { AxiosService } from './axios.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'crud-angular';



  @Input() logoUcsal: string = './assets/images/logoUcsal.png';
  active = 1;



  constructor(private AxiosService: AxiosService) { }


  isAuthenticated(): boolean {

    return this.AxiosService.isAuthenticated();

  }

  isAdm(): boolean {

    return this.AxiosService.getRole()?.role == "ADMIN" ? true : false;
  }
  isMedico(): boolean {

    return this.AxiosService.getRole()?.role == "MEDICO" ? true : false;
  }



}

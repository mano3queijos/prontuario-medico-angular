import { AxiosService } from './axios.service';
import { Component, Input } from '@angular/core';
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

}

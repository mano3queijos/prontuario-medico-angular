import { EventEmitter, Component, Output } from '@angular/core';
import { AxiosService } from '../axios.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {

  @Output() onSubmitLoginEvent = new EventEmitter();
  @Output() onSubmitRegisterEvent = new EventEmitter();



  constructor(private axiosService: AxiosService) { }

  login: string = "";
  password: string = "";
  errorMsg: string = "";

  onSubmitLogin(): void {
    this.axiosService.request(
      "POST",
      "/auth/login",
      {
        login: this.login,
        password: this.password
      }).then(
        response => {
          this.axiosService.setAuthToken(response.data.token);
          console.log(response.data.token);
        }).catch(
          error => {
            this.axiosService.setAuthToken(null);
            this.errorMsg = "Ocorreu um erro: " + error.message;
          }
        );

  }

}

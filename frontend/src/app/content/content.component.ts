import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent {

	  isLoggedIn: boolean = false;

	componentToShow: string = "welcome";
	constructor(private axiosService: AxiosService) { 
		
	
	}
	

	handleLoginSuccess() {
    // Lógica de verificação de login bem-sucedido
    // Após a verificação bem-sucedida, defina isLoggedIn como true
    this.isLoggedIn = true;
  }


	showComponent(componentToShow: string): void {
    this.componentToShow = componentToShow;
  }

	onLogin(input: any): void {
		
		this.axiosService.request(

		    "POST",
		    "/auth/login",
		    {
		        login: input.login,
		        password: input.password
		    }).then(
		    response => {
		        this.axiosService.setAuthToken(response.data.id);
		        this.componentToShow = "messages";
		    }).catch(
		    error => {
		        this.axiosService.setAuthToken(null);
		    }
		);

	}

	onSubmitRegister(input: any): void {
		this.axiosService.request(
		    "POST",
		    "/auth/register",
		    {
		        firstName: input.firstName,
		        lastName: input.lastName,
		        login: input.login,
		        password: input.password
		    }).then(
		    response => {
		        this.axiosService.setAuthToken(response.data.id);
		        this.componentToShow = "messages";
		    }).catch(
		    error => {
		        this.axiosService.setAuthToken(null);
		        this.componentToShow = "welcome";
		    }
		);
	}
	

}

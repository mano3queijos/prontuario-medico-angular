import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';

import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from '../shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent {

	 errorMessage: string = "";
	componentToShow: string = "null";

	constructor(private axiosService: AxiosService,
		public dialog: MatDialog) { }

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
		        this.axiosService.setAuthToken(response.data.token);
		        this.componentToShow = "navbar";
		    }).catch(
		    error => {
		        this.axiosService.setAuthToken(null);
		        this.componentToShow = "login";
// this.onError(error)
alert("aconteceu um")

}
		);

	}


  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: 
errorMsg
	
    });
  }
	
	onRegister(input: any): void {
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
		        this.axiosService.setAuthToken(response.data.token);
		        alert("registrado com susexo")
		    }).catch(
		    error => {
		        this.axiosService.setAuthToken(null);
				alert("aconteceu algum erro")
		    }
		);
	}

}
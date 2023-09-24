import { EventEmitter, Component, Renderer2 ,Output, Input} from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
  })
  
export class LoginFormComponent {


  @Output() onSubmitLoginEvent = new EventEmitter();
  @Output() onSubmitRegisterEvent = new EventEmitter();
  @Output() loginEvent = new EventEmitter();
	@Output() logoutEvent = new EventEmitter();
componentToShow: string = 'welcome';
  @Input() accessButtonVisible: boolean = true;


	active: string = "login";
  firstName: string = "";
  lastName: string = "";
  login: string = "";
  password: string = "";

	onLoginTab(): void {
		this.active = "login";
	}

	onRegisterTab(): void {
		this.active = "register";
	}

  
  onExitButtonClick() {
    // Emita o evento de logout
    this.logoutEvent.emit();

    // Recarregue a página
    window.location.reload();
  }

  onSubmitLogin(): void {
    this.onSubmitLoginEvent.emit({"login": this.login, "password": this.password});
  }

  onSubmitRegister(): void {
    this.onSubmitRegisterEvent.emit({"firstName": this.firstName, "lastName": this.lastName, "login": this.login, "password": this.password});
  }

}

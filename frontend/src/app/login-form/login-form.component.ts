import { EventEmitter, Component, Output, Input } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
})
export class LoginFormComponent {
  @Output() onSubmitLoginEvent = new EventEmitter();
  @Output() loginEvent = new EventEmitter();
  @Output() logoutEvent = new EventEmitter();
  @Input() accessButtonVisible: boolean = true;

  active: string = 'login';
  login: string = '';
  password: string = '';
  loginError: string | null = null; // Adicione uma propriedade para a mensagem de erro

  onLoginTab(): void {
    this.active = 'login';
  }

  onRegisterTab(): void {
    this.active = 'register';
  }

  onExitButtonClick() {
    // Emita o evento de logout
    this.logoutEvent.emit();
  }

  onSubmitLogin(): void {
  
    try {
    // Emita o evento de login, incluindo credenciais
    this.onSubmitLoginEvent.emit({ login: this.login, password: this.password });
  } catch (error) {
    // Se ocorrer uma exceção, trate-a aqui
    console.error('Erro ao emitir o evento de login:', error);

    // Defina a mensagem de erro com base na exceção
    this.handleLoginError('Ocorreu um erro durante o login. Tente novamente.');
  }

  }

  // Método para lidar com o erro de login
  handleLoginError(errorMessage: string) {
    this.loginError = errorMessage;
  }
}

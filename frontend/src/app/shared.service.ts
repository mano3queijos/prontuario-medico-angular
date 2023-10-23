// shared.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SharedService {
  loginError: string | null = null;

  setLoginError(error: string): void {
    this.loginError = error;
  }

  clearLoginError(): void {
    this.loginError = null;
  }
}

import { Injectable } from '@angular/core';
import axios from 'axios';
// import * as jwt from 'jsonwebtoken';

@Injectable({
  providedIn: 'root'
})
export class AxiosService {

  constructor() {
    axios.defaults.baseURL = 'http://localhost:8080';
    axios.defaults.headers.post['Content-Type'] = 'application/json';
  }

  getAuthToken(): string | null {
    return window.localStorage.getItem("auth_token");

  }

  getRole(): { username: string, role: string } | null {
    const token = this.getAuthToken();
    if (token) {
      const payload = token.split('.')[1];
      const decodedPayload = JSON.parse(atob(payload));
      return {
        username: decodedPayload.nome,
        role: decodedPayload.role
      };
    }
    return null;
  }


  setAuthToken(token: string | null): void {
    if (token !== null) {
      window.localStorage.setItem("auth_token", token);
    } else {
      window.localStorage.removeItem("auth_token");
    }
  }


  isAuthenticated(): boolean {
    const authToken = this.getAuthToken(); // Chame a função para obter o token JWT
    return !!authToken; // Verifique se authToken existe e não é nulo
  }


  logout(): void {
    this.setAuthToken(null);
  }


  request(method: string, url: string, data: any): Promise<any> {
    let headers: any = {};

    if (this.getAuthToken() !== null) {
      headers = { "Authorization": "Bearer " + this.getAuthToken() };
      console.log("Token:", this.getAuthToken()); // Adicione esta linha para imprimir o token

    }

    return axios({
      method: method,
      url: url,
      data: data,
      headers: headers
    });
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Paciente } from './paciente/shared/paciente';

const baseUrl = 'http://localhost:8080/paciente';

@Injectable({
  providedIn: 'root'
})


export class PacienteService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Paciente[]> {
    return this.http.get<Paciente[]>(baseUrl);
  }

  get(id: any): Observable<Paciente> {
    return this.http.get<Paciente>(`${baseUrl}/${id}`);
  }

create(data: any): Observable<any> {
  return this.http.post(`${baseUrl}/cadastrar`, data);
}


  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/deletar/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findById(title: any): Observable<Paciente[]> {
    return this.http.get<Paciente[]>(`${baseUrl}?title=${title}`);
  }
}

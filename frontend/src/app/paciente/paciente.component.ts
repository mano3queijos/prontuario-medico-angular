import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.css']
})
export class PacienteComponent {


constructor(private router: Router) {}


  abrirCadastroPaciente(): void {
    this.router.navigate(['../cadastro-paciente']);
  }

}

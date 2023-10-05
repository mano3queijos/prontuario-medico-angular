
import { Component, OnInit } from '@angular/core';
import { Paciente } from '../paciente/shared/paciente';
import { PacienteService } from '../paciente.service';

@Component({
  selector: 'app-paciente-list',
  templateUrl: './paciente-list.component.html',
  styleUrls: ['./paciente-list.component.css']
})
export class PacienteListComponent implements OnInit {
  pacientes: any[]=[];

    constructor(private pacienteService: PacienteService) { }


    ngOnInit(): void {
        // this.pacienteService.getAll().subscribe((data)=>{
        //   this.pacientes = data;
        // })
            this.pacientes = this.pacienteService.obterPacientes();


      //      this.pacientes = [
      // {
      //   id: 1,
      //   nome: 'João',
      //   idade: 30,
      // },
      // {
      //   id: 2,
      //   nome: 'Maria',
      //   idade: 25,
      // },
      //   ];
    }



}

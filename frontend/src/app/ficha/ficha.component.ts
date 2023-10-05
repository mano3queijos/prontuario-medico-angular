import { Component,OnInit } from '@angular/core';
import { Paciente } from '../paciente/shared/paciente';
import { PacienteService } from '../paciente.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-ficha',
  templateUrl: './ficha.component.html',
  styleUrls: ['./ficha.component.css']
})
export class FichaComponent implements OnInit {


  paciente: any; 
   pacienteId: any;

    constructor(private pacienteService: PacienteService, private route: ActivatedRoute) { }

    ngOnInit(): void {
    
          this.pacienteId = this.route.snapshot.params["id"];
          
                this.paciente = this.pacienteService.obterPacientesPorId(this.pacienteId);

                //fazer o tratamento de erro adequado


          // this.paciente = this.pacienteService.obterPacientePorId(this.pacienteId);

            // this.pacientes = this.pacienteService.obterPacientes();

    }
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

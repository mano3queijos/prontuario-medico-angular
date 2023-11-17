import { AppComponent } from './../app.component';
import { CriarMedicoComponent } from './create/criar-medico/criar-medico.component';
import { Component, OnInit } from '@angular/core';
import { Medico } from '../shared/model/medico';
import { AxiosService } from '../axios.service';
import { response } from 'express';
import { Router } from '@angular/router';
import { MedicoService } from './medico.service';
import { ChangeDetectorRef } from '@angular/core';



@Component({
  selector: 'app-medico',
  templateUrl: './medico.component.html',
  styleUrls: ['./medico.component.scss']
})
export class MedicoComponent implements OnInit {


  medicos: Medico[] = [];
  errorMsg: string = "";
  isLoading = true;

  constructor(private axiosService: AxiosService, private medicoService: MedicoService, private router: Router) {



  }

  ngOnInit(): void {
    this.getMedicos();

  }
  getMedicos() {
    this.medicoService.fetchMedicos().then(result => {


      this.medicos = result.medicos;
      this.errorMsg = result.errorMessage;
      console.log(this.medicos)
      this.isLoading = false;

    });

  }


  createMedcico() {

    this.router.navigate(['createMedico']);

  }



  viewMedico(id: number) {

    this.router.navigate(['viewMedico'])

  }


  deleteMedico(id: number) {

    this.router.navigate(['removeMedico'])

  }


  updateMedico(id: number) {

    this.router.navigate(['updateMedico'])


  }


  logout(): void {
    this.axiosService.logout();
  }



}

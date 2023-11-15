import { Component, OnInit } from '@angular/core';
import { Medico } from '../shared/model/medico';
import { AxiosService } from '../axios.service';
import { response } from 'express';


@Component({
  selector: 'app-medico',
  templateUrl: './medico.component.html',
  styleUrls: ['./medico.component.scss']
})
export class MedicoComponent implements OnInit {


  medicos: Medico[] = [];
  errorMsg: string = "";

  constructor(private axiosService: AxiosService) { }

  ngOnInit(): void {

    this.fetchMedicos();
  }


  fetchMedicos() {

    this.axiosService.request("GET",
      "/auth/users", {}).then(response => {
        this.medicos = response.data;
      }).catch(error => {
        this.errorMsg = "Ocorreu um erro: " + error.message;

      })


  }

  logout(): void {
    this.axiosService.logout();
  }



}

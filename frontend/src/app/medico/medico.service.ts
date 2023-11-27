import { ChangeDetectorRef, Injectable } from '@angular/core';
import { AxiosService } from '../axios.service';
import { Medico } from '../shared/model/medico';
import { response } from 'express';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  constructor(private axiosService: AxiosService) { }
  reload = true;

  medicos: Medico[] = [];
  errorMsg: string = "";

  async fetchMedicos(): Promise<{ medicos: Medico[], errorMessage: string }> {

    while (this.medicos.length == 0) {
      try {
        const response = await this.axiosService.request("GET", "/auth/users", {});
        this.medicos = response.data;
      } catch (error) {
        this.errorMsg = "Ocorreu um erro: " + (error as Error).message;
        alert(this.errorMsg)
      }
    }

    return { medicos: this.medicos, errorMessage: this.errorMsg };
  }


  deleteMedicos(id: number) {

    this.axiosService.request(
      "DELETE",
      "/auth/delete",
      {
        id
      }).then(
        response => {

          console.log(response.data)

        }).catch(
          error => {
            this.errorMsg = "Ocorreu um erro: " + error.message;
          }
        );

  }

  registerMedicos(medico: Medico) {

    this.axiosService.request("POST", "/auth/register", { medico }).then(response => {
      alert(response.data)
    }).catch(error => {
      alert("Ocorreu um erro: " + error.message);
    })


  }
}


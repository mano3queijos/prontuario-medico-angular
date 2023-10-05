import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PacienteComponent } from './paciente/paciente.component';
import { AgendaComponent } from './agenda/agenda.component';
import { ConsultaComponent } from './consulta/consulta.component';
import { CadastroPacienteComponent } from './cadastro-paciente/cadastro-paciente.component';
import { FichaComponent } from './ficha/ficha.component';

const routes: Routes = [

  { path: 'home', component: HomeComponent },
  { path: 'paciente', component: PacienteComponent },
  { path: 'agenda', component: AgendaComponent },
  { path: 'consulta', component: ConsultaComponent },
 { path: 'cadastro-paciente', component: CadastroPacienteComponent },
 {path: 'ficha/:id', component : FichaComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

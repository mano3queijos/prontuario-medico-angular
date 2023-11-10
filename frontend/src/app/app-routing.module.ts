import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MedicoComponent } from './medico/medico.component';
import { AdmsComponent } from './adms/adms.component';

const routes: Routes = [{ path: '', pathMatch: 'full', redirectTo: 'login' }, {
  path: 'pacientes',
  loadChildren: () => import('./pacientes/pacientes.module').then(m => m.PacientesModule)
},
{ path: 'home', component: HomeComponent }, { path: 'medico', component: MedicoComponent }, { path: 'adm', component: AdmsComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

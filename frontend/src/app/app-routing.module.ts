import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MedicoComponent } from './medico/medico.component';
import { AdmsComponent } from './adms/adms.component';
import { DetalharMedicoComponent } from './medico/detail/detalhar-medico/detalhar-medico.component';
import { CriarMedicoComponent } from './medico/create/criar-medico/criar-medico.component';
import { AtualizarMedicoComponent } from './medico/update/atualizar-medico/atualizar-medico.component';
import { RemoverMedicoComponent } from './medico/remove/remover-medico/remover-medico.component';

const routes: Routes = [{ path: '', pathMatch: 'full', redirectTo: 'login' }, {
  path: 'pacientes',
  loadChildren: () => import('./pacientes/pacientes.module').then(m => m.PacientesModule)
},
{ path: 'home', component: HomeComponent }, { path: 'medico', component: MedicoComponent }, { path: 'adm', component: AdmsComponent }, { path: 'viewMedico', component: DetalharMedicoComponent }, { path: 'createMedico', component: CriarMedicoComponent }, { path: 'updateMedico', component: AtualizarMedicoComponent }, {
  path: 'removeMedico', component: RemoverMedicoComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

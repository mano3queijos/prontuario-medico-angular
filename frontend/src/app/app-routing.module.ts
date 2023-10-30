import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

const routes: Routes = [{ path: '', pathMatch: 'full', redirectTo: 'login' }, {
  path: 'pacientes',
  loadChildren: () => import('./pacientes/pacientes.module').then(m => m.PacientesModule)
},
{ path: 'home', component: HomeComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

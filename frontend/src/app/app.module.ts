import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdmsComponent } from './adms/adms.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { CriarMedicoComponent } from './medico/create/criar-medico/criar-medico.component';
import { DetalharMedicoComponent } from './medico/detail/detalhar-medico/detalhar-medico.component';
import { MedicoComponent } from './medico/medico.component';
import { RemoverMedicoComponent } from './medico/remove/remover-medico/remover-medico.component';
import { AtualizarMedicoComponent } from './medico/update/atualizar-medico/atualizar-medico.component';
import { NavbarAdmComponent } from './navbar-adm/navbar-adm.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [AppComponent, LoginComponent, NavbarComponent, HomeComponent, NavbarAdmComponent, MedicoComponent, AdmsComponent, CriarMedicoComponent, RemoverMedicoComponent, AtualizarMedicoComponent, DetalharMedicoComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule, MatFormFieldModule,


    NgbModule, FormsModule, FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }


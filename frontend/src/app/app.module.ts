import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ButtonsComponent } from './buttons/buttons.component';
import { HeaderComponent } from './header/header.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { WelcomeContentComponent } from './welcome-content/welcome-content.component';
import { AuthContentComponent } from './auth-content/auth-content.component';
import { ContentComponent } from './content/content.component';

import { AxiosService } from './axios.service';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { PacienteComponent } from './paciente/paciente.component';
import { ConsultaComponent } from './consulta/consulta.component';
import { AgendaComponent } from './agenda/agenda.component';
import { CadastroPacienteComponent } from './cadastro-paciente/cadastro-paciente.component';
import { HttpClientModule } from '@angular/common/http';
import { PacienteListComponent } from './paciente-list/paciente-list.component';
import { FichaComponent } from './ficha/ficha.component';
import { SharedModule } from './shared/shared.module';
import { MatDialogModule } from '@angular/material/dialog';


@NgModule({
  declarations: [
    AppComponent,
    ButtonsComponent,
    HeaderComponent,
    LoginFormComponent,
    WelcomeContentComponent,
    AuthContentComponent,
    ContentComponent,
    NavbarComponent,
    HomeComponent,
    PacienteComponent,
    ConsultaComponent,
    AgendaComponent,
    CadastroPacienteComponent,
    PacienteListComponent,
    FichaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
        HttpClientModule, 
        SharedModule,MatDialogModule,

  ],
  providers: [AxiosService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { AxiosService } from '../axios.service';

import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  activeCollapse: string | null = null; // Define null para nenhum colapso ativo por padrão

  collapses: { name: string; isCollapsed: boolean }[] = [
    { name: 'paginaInicial', isCollapsed: true },
    { name: 'paciente', isCollapsed: true },
    { name: 'consulta', isCollapsed: true },
    { name: 'agenda', isCollapsed: true },
    // Adicione mais colapsos conforme necessário
  ];
  constructor(private AxiosService: AxiosService) { }

  toggleCollapse(collapseName: string) {
    if (this.activeCollapse === collapseName) {
      this.activeCollapse = null; // Fecha o colapso se ele estiver aberto
    } else {
      this.activeCollapse = collapseName; // Abre o colapso clicado
    }
  }

  isActive(collapseName: string): boolean {
    return this.activeCollapse === collapseName;
  }

  logout(): void {
    this.AxiosService.logout();
  }

  isAuthenticated(): boolean {
    return this.AxiosService.isAuthenticated();
  }

}

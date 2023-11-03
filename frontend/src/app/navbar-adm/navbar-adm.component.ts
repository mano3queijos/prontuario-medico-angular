import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';

@Component({
  selector: 'app-navbar-adm',
  templateUrl: './navbar-adm.component.html',
  styleUrls: ['./navbar-adm.component.scss']
})
export class NavbarAdmComponent {
  activeCollapse: string | null = null; // Define null para nenhum colapso ativo por padrão

  collapses: { name: string; isCollapsed: boolean }[] = [
    { name: 'paginaInicial', isCollapsed: true },
    { name: 'Medicos', isCollapsed: true },
    { name: 'Adms', isCollapsed: true },
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

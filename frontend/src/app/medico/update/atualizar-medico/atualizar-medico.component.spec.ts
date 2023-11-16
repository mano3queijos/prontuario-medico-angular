import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtualizarMedicoComponent } from './atualizar-medico.component';

describe('AtualizarMedicoComponent', () => {
  let component: AtualizarMedicoComponent;
  let fixture: ComponentFixture<AtualizarMedicoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AtualizarMedicoComponent]
    });
    fixture = TestBed.createComponent(AtualizarMedicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

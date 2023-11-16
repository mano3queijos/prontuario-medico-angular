import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalharMedicoComponent } from './detalhar-medico.component';

describe('DetalharMedicoComponent', () => {
  let component: DetalharMedicoComponent;
  let fixture: ComponentFixture<DetalharMedicoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetalharMedicoComponent]
    });
    fixture = TestBed.createComponent(DetalharMedicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

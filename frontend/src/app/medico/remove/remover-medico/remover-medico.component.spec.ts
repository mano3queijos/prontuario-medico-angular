import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoverMedicoComponent } from './remover-medico.component';

describe('RemoverMedicoComponent', () => {
  let component: RemoverMedicoComponent;
  let fixture: ComponentFixture<RemoverMedicoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RemoverMedicoComponent]
    });
    fixture = TestBed.createComponent(RemoverMedicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

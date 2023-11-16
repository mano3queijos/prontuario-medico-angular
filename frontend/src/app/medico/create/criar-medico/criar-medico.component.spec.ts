import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarMedicoComponent } from './criar-medico.component';

describe('CriarMedicoComponent', () => {
  let component: CriarMedicoComponent;
  let fixture: ComponentFixture<CriarMedicoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CriarMedicoComponent]
    });
    fixture = TestBed.createComponent(CriarMedicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

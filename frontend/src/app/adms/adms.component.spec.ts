import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmsComponent } from './adms.component';

describe('AdmsComponent', () => {
  let component: AdmsComponent;
  let fixture: ComponentFixture<AdmsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdmsComponent]
    });
    fixture = TestBed.createComponent(AdmsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

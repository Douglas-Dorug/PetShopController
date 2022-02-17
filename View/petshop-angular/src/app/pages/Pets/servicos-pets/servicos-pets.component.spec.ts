import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicosPetsComponent } from './servicos-pets.component';

describe('ServicosPetsComponent', () => {
  let component: ServicosPetsComponent;
  let fixture: ComponentFixture<ServicosPetsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServicosPetsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicosPetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

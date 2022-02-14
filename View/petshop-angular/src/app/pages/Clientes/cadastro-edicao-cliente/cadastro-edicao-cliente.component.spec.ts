import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroEdicaoClienteComponent } from './cadastro-edicao-cliente.component';

describe('CadastroEdicaoClienteComponent', () => {
  let component: CadastroEdicaoClienteComponent;
  let fixture: ComponentFixture<CadastroEdicaoClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroEdicaoClienteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroEdicaoClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

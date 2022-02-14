import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicosClientesComponent } from './servicos-clientes.component';

describe('ServicosClientesComponent', () => {
  let component: ServicosClientesComponent;
  let fixture: ComponentFixture<ServicosClientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServicosClientesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicosClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

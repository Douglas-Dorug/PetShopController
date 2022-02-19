import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarTodosPorClienteComponent } from './listar-todos-por-cliente.component';

describe('ListarTodosPorClienteComponent', () => {
  let component: ListarTodosPorClienteComponent;
  let fixture: ComponentFixture<ListarTodosPorClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarTodosPorClienteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarTodosPorClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

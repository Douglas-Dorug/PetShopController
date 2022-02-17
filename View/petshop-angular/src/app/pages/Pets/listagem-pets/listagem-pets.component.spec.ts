import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemPetsComponent } from './listagem-pets.component';

describe('ListagemPetsComponent', () => {
  let component: ListagemPetsComponent;
  let fixture: ComponentFixture<ListagemPetsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListagemPetsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListagemPetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

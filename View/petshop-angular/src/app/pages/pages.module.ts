import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { ServicosClientesComponent } from './Clientes/servicos-clientes/servicos-clientes.component';
import { ListarTodosComponent } from './Clientes/listar-todos/listar-todos.component';
import { CadastroEdicaoClienteComponent } from './Clientes/cadastro-edicao-cliente/cadastro-edicao-cliente.component';
import { ServicosPetsComponent } from './Pets/servicos-pets/servicos-pets.component';
import { ListagemPetsComponent } from './Pets/listagem-pets/listagem-pets.component';
import { CadastroPetsComponent } from './Pets/cadastro-pets/cadastro-pets.component';



@NgModule({
  declarations: [
    HomeComponent,
    ServicosClientesComponent,
    ListarTodosComponent,
    CadastroEdicaoClienteComponent,
    ServicosPetsComponent,
    ListagemPetsComponent,
    CadastroPetsComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ]
})
export class PagesModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { ServicosClientesComponent } from './Clientes/servicos-clientes/servicos-clientes.component';
import { ListarTodosComponent } from './Clientes/listar-todos/listar-todos.component';



@NgModule({
  declarations: [
    HomeComponent,
    ServicosClientesComponent,
    ListarTodosComponent
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

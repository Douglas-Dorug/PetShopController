import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarTodosComponent } from './pages/Clientes/listar-todos/listar-todos.component';
import { ServicosClientesComponent } from './pages/Clientes/servicos-clientes/servicos-clientes.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'clientes', component: ServicosClientesComponent
  },
  {
    path: 'clientes/lista', component: ListarTodosComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

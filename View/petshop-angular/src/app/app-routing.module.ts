import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroEdicaoClienteComponent } from './pages/Clientes/cadastro-edicao-cliente/cadastro-edicao-cliente.component';
import { ListarTodosComponent } from './pages/Clientes/listar-todos/listar-todos.component';
import { ServicosClientesComponent } from './pages/Clientes/servicos-clientes/servicos-clientes.component';
import { HomeComponent } from './pages/home/home.component';
import { CadastroPetsComponent } from './pages/Pets/cadastro-pets/cadastro-pets.component';
import { ListagemPetsComponent } from './pages/Pets/listagem-pets/listagem-pets.component';
import { ServicosPetsComponent } from './pages/Pets/servicos-pets/servicos-pets.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'clientes', component: ServicosClientesComponent
  },
  {
    path: 'clientes/lista', component: ListarTodosComponent
  },
  {
    path: 'clientes/cadastro', component: CadastroEdicaoClienteComponent
  },
  {
    path: 'clientes/lista/editar/:id', component: CadastroEdicaoClienteComponent
  },
  {
    path: 'pets', component: ServicosPetsComponent
  },
  {
    path: 'pets/lista', component: ListagemPetsComponent
  },
  {
    path: 'pets/cadastro', component: CadastroPetsComponent
  },
  {
    path: 'pets/lista/editar/:id', component: CadastroPetsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

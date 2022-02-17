import { Component, OnInit } from '@angular/core';
import { IClientes } from 'src/app/interfaces/clientes';
import { ClienteService } from 'src/app/services/cliente.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-todos',
  templateUrl: './listar-todos.component.html',
  styleUrls: ['./listar-todos.component.css']
})
export class ListarTodosComponent implements OnInit {

  clientes: IClientes[]= [];
  constructor(private clientesService: ClienteService) { }

  ngOnInit(): void {
    this.listarTodos();
  }

  listarTodos(){
    this.clientesService.listarTodosClientes().subscribe((result: any) => {
    this.clientes = result;
  })
}


  deletarCliente(id: number){
    Swal.fire({
      title: 'Deseja realmente prosseguir?',
      text: "Esta ação não poderá ser desfeita!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
     confirmButtonText: 'Sim, delete!'
    }).then((result) => {
      if (result.isConfirmed){
        this.clientesService.removerCliente(id).subscribe(result => {
         this.listarTodos();
         Swal.fire(
          'Deletado!',
          'O cliente foi removido com sucesso!',
          'success'
         )
        }, error =>{
          Swal.fire('Opa......','Algo deu errado durante a operação!','error')
        console.error(error)
        })
      }
    })
  }

}

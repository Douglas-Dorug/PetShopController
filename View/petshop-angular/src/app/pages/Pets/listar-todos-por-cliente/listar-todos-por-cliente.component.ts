import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IPets } from 'src/app/interfaces/pets';
import { PetService } from 'src/app/services/pet.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-todos-por-cliente',
  templateUrl: './listar-todos-por-cliente.component.html',
  styleUrls: ['./listar-todos-por-cliente.component.css']
})
export class ListarTodosPorClienteComponent implements OnInit {

  pets: IPets[] = [];


  constructor(
    private petsService: PetService,
    private router: Router,
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id') || "";
    this.listarTodos(id);
  }

  listarTodos(id: string){
    this.petsService.listarTodosPetsIdCliente(id).subscribe((result: any) =>{
      this.pets = result;
    })
  }

  deletarPet(id: number){
    Swal.fire({
      title: 'Deseja realmente prosseguir?',
      text: "Esta ação não poderá ser desfeita!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
     confirmButtonText: 'Sim, delete!'
    }).then((result) =>{
      if(result.isConfirmed){
        this.petsService.removerPet(id).subscribe(result => {
          Swal.fire(
            'Deletado!',
            'O Pet foi removido com sucesso!',
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

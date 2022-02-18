import { Component, OnInit } from '@angular/core';
import { IPets } from 'src/app/interfaces/pets';
import { PetService } from 'src/app/services/pet.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listagem-pets',
  templateUrl: './listagem-pets.component.html',
  styleUrls: ['./listagem-pets.component.css']
})
export class ListagemPetsComponent implements OnInit {

  pets: IPets[] = [];

  constructor(private petsService: PetService) { }

  ngOnInit(): void {
    this.listarTodos();
  }

  listarTodos(){
    this.petsService.listarTodosPets().subscribe((result: any) =>{
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
          this.listarTodos();
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

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { IPetCadastro } from 'src/app/interfaces/pet-cadastro';
import { IPets } from 'src/app/interfaces/pets';
import { PetService } from 'src/app/services/pet.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cadastro-pets',
  templateUrl: './cadastro-pets.component.html',
  styleUrls: ['./cadastro-pets.component.css']
})
export class CadastroPetsComponent implements OnInit {

  formValue: FormGroup = new FormGroup({
    id: new FormControl(null),
    type: new FormControl('', Validators.required),
    nome: new FormControl('', Validators.required),
    idade: new FormControl(''),
    raca: new FormControl(''),
    idCliente: new FormControl('', Validators.required),
    })

  constructor(
    private petService: PetService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if(Number(id)){
      this.petService.buscarPorId(Number (id)).subscribe(resultPet =>{
        this.preencheFormValue(resultPet)
      })
      console.log(id);
    }
  }

  preencheFormValue(pets: IPets){
    this.formValue= new FormGroup({
      id: new FormControl(pets.id),
      type: new FormControl(pets.type, Validators.required),
      nome: new FormControl(pets.nome, Validators.required),
      idade: new FormControl(pets.idade),
      raca: new FormControl(pets.raca),
      idCliente: new FormControl(pets.costumer.id, Validators.required)
    })
  }

  enviar(){
    const pet: IPetCadastro = this.formValue.value;
    this.petService.cadastrar(pet).subscribe(result =>{
      Swal.fire('Sucesso!!','Cadastro realizado com sucesso!', 'success')
      this.router.navigate(['/pets/lista']);
    }, error =>{
      Swal.fire('Opa......','Algo deu errado no cadastro!','error')
      console.error(error)
    });
  }

}

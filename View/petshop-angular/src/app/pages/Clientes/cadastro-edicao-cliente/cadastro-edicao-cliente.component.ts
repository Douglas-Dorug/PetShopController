import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from 'src/app/services/cliente.service';
import { IClientes } from 'src/app/interfaces/clientes';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cadastro-edicao-cliente',
  templateUrl: './cadastro-edicao-cliente.component.html',
  styleUrls: ['./cadastro-edicao-cliente.component.css']
})
export class CadastroEdicaoClienteComponent implements OnInit {

  formValue: FormGroup = new FormGroup({
  id: new FormControl(null),
  fullName: new FormControl('', Validators.required),
  cpf: new FormControl('', Validators.required),
  birthDate: new FormControl(''),
  email: new FormControl('', [Validators.required, Validators.email]),
  rua: new FormControl('', Validators.required),
  bairro: new FormControl('', Validators.required),
  numeroCasa: new FormControl('', Validators.required),
  referencia: new FormControl(''),
  numContato: new FormControl('', Validators.required),
  })

  constructor(
    private clienteService: ClienteService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if(Number(id)){
      this.clienteService.buscarPorId(Number (id)).subscribe(resultCliente =>{
        this.preencheFormValue(resultCliente)
      })
      console.log(id);
    }
  }

  preencheFormValue(costumer: IClientes){
    this.formValue= new FormGroup({
      id: new FormControl(costumer.id),
      fullName: new FormControl(costumer.fullName, Validators.required),
      cpf: new FormControl(costumer.cpf, Validators.required),
      birthDate: new FormControl(costumer.birthDate),
      email: new FormControl(costumer.email, [Validators.required, Validators.email]),
      rua: new FormControl(costumer.email, Validators.required),
      bairro: new FormControl(costumer.bairro, Validators.required),
      numeroCasa: new FormControl(costumer.numeroCasa, Validators.required),
      referencia: new FormControl(costumer.referencia),
      numContato: new FormControl(costumer.numContato, Validators.required),
    })
  }

  enviar(){
    const costumer: IClientes = this.formValue.value;
    this.clienteService.cadastrar(costumer).subscribe(result =>{
      Swal.fire('Sucesso!!','Cadastro realizado com sucesso!', 'success')
      this.router.navigate(['/clientes/lista']);
    }, error =>{
      Swal.fire('Opa......','Algo deu errado no cadastro!','error')
      console.error(error)
    });
  }
}

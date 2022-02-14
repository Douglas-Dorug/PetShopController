import { Component, OnInit } from '@angular/core';
import { IClientes } from 'src/app/interfaces/clientes';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-listar-todos',
  templateUrl: './listar-todos.component.html',
  styleUrls: ['./listar-todos.component.css']
})
export class ListarTodosComponent implements OnInit {

  clientes: IClientes[]= [];
  constructor(private clientesService: ClienteService) { }

  ngOnInit(): void {
    console.log("chegou ate aqui")
    this.clientesService.listarTodosClientes().subscribe((result: any) => {
      this.clientes = result;
    })
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { IClientes } from '../interfaces/clientes';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  endpoint = 'clientes';
  api = environment.api;

  constructor(private http: HttpClient) { }

  listarTodosClientes(){
    return this.http.get<IClientes[]>(`${this.api}/${this.endpoint}/listar-clientes`);
  }

  cadastrar(costumer: IClientes){
    return this.http.post(`${this.api}/${this.endpoint}`, costumer);
  }
  buscarPorId(id: number){
    return this.http.get<IClientes>(`${this.api}/${this.endpoint}/obter-cliente/${id}`);
  }
}

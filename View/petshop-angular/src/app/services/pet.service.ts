import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { IPetCadastro } from '../interfaces/pet-cadastro';
import { IPets } from '../interfaces/pets';

@Injectable({
  providedIn: 'root'
})
export class PetService {
  endpoint = 'pets';
  api = environment.api;

  constructor(private http: HttpClient) { }

  listarTodosPets(){
    return this.http.get<IPets[]>(`${this.api}/${this.endpoint}/listar-todos`);
  }

  listarTodosPetsIdCliente(id: string){
    return this.http.get<IPets[]>(`${this.api}/${this.endpoint}/consulta-pets-por-id-cliente/${id}`)
  }

  editar(pet: IPets){
    return this.http.post(`${this.api}/${this.endpoint}`, pet);
  }

  cadastrar(pet: IPetCadastro){
    return this.http.post(`${this.api}/${this.endpoint}`, pet);
  }

  buscarPorId(id: number){
    return this.http.get<IPets>(`${this.api}/${this.endpoint}/consultar-pets/${id}`);
  }

  removerPet(id: number){
    return this.http.delete(`${this.api}/${this.endpoint}/deletar-pets/${id}`)
  }
}

import { IClientes } from "./clientes";

export interface IPets{
  id: number;
  type: string;
  nome: string;
  idade: string;
  raca: string;
  costumer: IClientes;
  idCliente: string;
}

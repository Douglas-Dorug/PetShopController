# Projeto Cadastro Cliente Petshop

## Objetivo

- No Bootcamp Code-Anywhere foi desenvolvido um sistema de gerenciamento de pessoas utilizando API REST.
    - O mesmo pode ser encontrado no link: [Douglas-Dorug/person_api_bootcamp: Project from DIO for User registration (github.com)](https://github.com/Douglas-Dorug/person_api_bootcamp)
  
- Visando utilizar o mesmo conceito visto no curso, mas criando alterações, optei por criar um sistema API REST para cadastro de clientes em um petshop.

- Assim, foi criado um **API REST** para _cadastrar_, _alterar_, _recuperar_ e _deletar_ um cliente, com todas as informações que o mesmo possui.

- Iremos criar nossa API utilizando o sistema de banco de dados **H2**.

- O cliente, conta com as seguintes informações:
  - Nome
  - CPF
  - Data de Nascimento
  - Endereço
    - Nome da rua com bairro.
    - Número do endereço.
    - Referencia de local proximo ou detalhes da casa.
    - Utilizado a relação `@OneToOne`
  - Telefone
    - Numero com DDD e tipo do aparelho.
    - Utilizado a relação `@OneToMany`.
  - Pets
    - Nome, raça e tipo.
    - Nesse caso também foi utilizado a relação `@OneToMany`, visto que os clientes também podem ter mais de um pet.

### Sobre as Camadas

#### Entity

- Aqui iniciamos com a criação das entidades que existem no nosso banco de dados, ela representa exatamente nosso banco
- Possuimos uma entidade para cada tabela do nosso banco de dados.
- O ponto mais importante das entidades é criar uma relação entre as tabelas. Para isso utilizamos anotações de relacionamento.
  - A tabela que será responsável, a "principal" entre as outras, é a **Costumer (Cliente)**.
#### Controller

- Camada responsável pelo mapeamento dos métodos HTTP. Essa é a camada que estará visível em nossa interface, para apartir do **path** definido enviarmos as requisições e informações para a camada Service.
- Nessa camada não vamos interagir com as entidades, a fim de seguir o padrão RESTful usaremos uma camada DTO, onde podemos definir regras para nosso atributo e controlar o que realmente vai para nosso banco de Dados. Em nosso exemplo vamos definir anotações de CPF. De forma a respeitarem o padrão correto, sem que seja necessário criar uma classe para checar se as informações passadas estão corretas.

#### Service

- Camada responsável pelas regras de negócio. As requisições provenientes da camada controller é recebida e executada, seguindo as regras definidas.
-  Nessa camada iremos interagir com o Banco de Dados, a partir da camada Repository.

#### Repository

- Camada na qual fazemos a interação com nosso banco de dados, salvando, alternado, recuperando e excluindo dados diretamente do banco.

### Como inserir dados

- A inserção de dados é feita a partir de um JSON. Um exemplo pode ser visto abaixo:

``` {
{
    "firstName":"Douglas",
    "lastName":"Luiz",
    "cpf": "999.999.999-99",
    "birthDate": "15-01-1997",
    "address": {
        "street": "Rua 10 de janeiro",
        "number": "205 B",
        "reference": "Casa azul de primeiro andar"
    },
    "phones": [
        {
            "type":"MOBILE",
            "number": "(81)9999999"
        }
    ],
    "pets": [
        {
            "type": "CAT",
            "name": "Chiquinho",
            "breed": "Sem raça definida"
        },
        {
            "type": "DOG",
            "name": "Bolt",
            "breed": "Sem raça definida"
        }
    ]

}
```

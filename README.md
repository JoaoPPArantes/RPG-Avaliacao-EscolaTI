
# Sistema de Gerenciamento de Personagens e Itens Mágicos - RPG API

Este projeto é uma API REST desenvolvida em Java com Spring Boot para gerenciamento de um sistema de RPG.

---

## Funcionalidades

-  Cadastro de personagens (com validação de força + defesa = 10)
- Listagem, busca e exclusão de personagens
- Cadastro de itens mágicos com tipos:
  - ARMA
  - ARMADURA
  - AMULETO
-  Associação de itens a personagens
-  Vincular item existente a personagem
-  Remoção de item de personagem
-  Buscar o amuleto de um personagem
-  Documentação automática com Swagger
-  Tratamento global de exceções

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Swagger
- Jakarta




## Endpoints principais
   
  Personagens 
  Método    Endpoint                                   Descrição

  POST      /itens                                    Cadastrar novo item                      
  GET       /itens                                    Listar todos os itens mágicos            
  GET       /itens/{id}                               Buscar item por ID                       
  POST      /itens/personagem/{personagemId}          Criar item e associar ao personagem      
  PUT       /itens/{itemId}/personagem/{personagemId} Associar item existente ao personagem
  GET       /itens/personagem/{personagemId}          Listar itens de um personagem            
  DELETE    /itens/personagem/{personagemId}/{itemId  Remover item de personagem            
  GET       /itens/personagem/{personagemId}/amuleto  Buscar amuleto do personagem

Itens Mágicos




Acesso ao swagger

http://localhost:8080/swagger-ui/index.html



Exemplo de JSON para criar personagem

json
{
  "nome": "João",
  "nomeAventureiro": "Mago Supremo",
  "classe": "Mago",
  "level": 5,
  "forcaBase": 4,
  "defesaBase": 6
}


Exemplo de JSON para criar item mágico

{
  "nomeItem": "Amuleto da Vida",
  "tipoItem": "AMULETO",
  "forca": 2,
  "defesa": 2
}



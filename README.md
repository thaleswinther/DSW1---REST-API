# DSW1-REST-API
Atividade avaliativa da disciplina Desenvolvimento de Software para Web 01 cujo objetivo é desenvolver um sistema para locação de bicicletas utilizando Spring, Java, com suporte para API REST
# Sistema para Locação de Bicicletas
Este projeto foi desenvolvido como uma parte avaliativa da disciplina Desenvolvimento de Software para Web 1, ministrada pelo professor Alan Demetrius. O principal objetivo desse trabalho
é criar uma aplicação web para um sistema de locação de bicicletas, a partir de um conjunto de requisitos.
## Requisitos da Aplicação
Atividade A-3: Sistema para locação de bicicletas <br>
Obs 1: Essa atividade deve ser baseada na atividade A-2. Ou seja, deve-se apenas implementar os
novos requisitos (funcionalidades providas em uma REST API) aqui mencionados -- levando em
consideração o que já foi desenvolvido na atividade A-2. <br>
O sistema deve incorporar os seguintes requisitos: <br>
### REST API -- CRUD de clientes <br>
  * Cria um novo cliente [Create - CRUD] <br>
POST http://localhost:8080/clientes <br>
Body: raw/JSON (application/json) <br>
* Retorna a lista de clientes [Read - CRUD] <br>
GET http://localhost:8080/clientes <br>
* Retorna o cliente de id = {id} [Read - CRUD] <br>
GET http://localhost:8080/clientes/{id} <br>
* Atualiza o cliente de id = {id} [Update - CRUD] <br>
PUT http://localhost:8080/clientes/{id} <br>
Body: raw/JSON (application/json) <br>
* Remove o cliente de id = {id} [Delete - CRUD]  <br>
DELETE http://localhost:8080/clientes/{id} <br> <br>


### REST API -- CRUD de locadoras
* Cria uma nova locadora [Create - CRUD] <br>
POST http://localhost:8080/locadoras <br>
Body: raw/JSON (application/json) <br>
* Retorna a lista de locadoras [Read - CRUD] <br>
GET http://localhost:8080/locadoras <br>
* Retorna a locadora de id = {id} [Read - CRUD]
[1] <br>
GET http://localhost:8080/locadoras/{id} <br>
* Retorna a lista de todas as locadoras da cidade de nome = {nome} <br>
GET http://localhost:8080/locadoras/cidades/{nome} <br>
* Atualiza a locadora de id = {id} [Update - CRUD]<br> 
PUT http://localhost:8080/locadoras/{id} <br>
Body: raw/JSON (application/json) <br>
* Remove a locadora de id = {id} [Delete - CRUD] <br>
DELETE http://localhost:8080/locadoras/{id} <br>

### REST API - Locações
* REST API -- Retorna a lista de locações [Read - CRUD] <br>
GET http://localhost:8080/locacoes <br>
* REST API -- Retorna a locação de id = {id} [Read - CRUD] <br>
GET http://localhost:8080/locacoes/{id} <br>
* REST API -- Retorna a lista das locações do cliente de id = {id} [Read - CRUD] <br>
GET http://localhost:8080/locacoes/clientes/{id} <br>
* REST API -- Retorna a lista de locações da locadora de id = {id} [Read - CRUD] <br>
GET http://localhost:8080/locacoes/locadoras/{id} <br> <br>

Obs 2: Em todas as funcionalidades mencionadas acima, não há necessidade de autenticação
(login) <br>
**Arquitetura: ** Modelo-Visão-Controlador <br>
### Tecnologias <br>
Spring MVC (Controladores REST), Spring Data JPA, Spring Security & Thymeleaf (Lado
Servidor) <br>
### Ambiente de Desenvolvimento <br>
A compilaçao e o deployment deve ser obrigatoriamente ser realizado via maven.
Os arquivos fonte do sistema devem estar hospedados obrigatoriamente em um repositório
(preferencialmente github). <br>
1. CRUD: Create, Read, Update & Delete. ↩

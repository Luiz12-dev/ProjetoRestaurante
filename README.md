Sistema de Gerenciamento de Cardápio (API RESTful)
Este projeto é uma API RESTful completa desenvolvida em Java com Spring Boot, projetada para gerenciar o cardápio de um restaurante de forma digital. O sistema permite realizar todas as operações de manipulação de dados de um cardápio, seguindo as melhores práticas de arquitetura de software e design de API.

Funcionalidades da API (Endpoints)
POST /api/pratos: Adiciona um novo prato ao cardápio.

GET /api/pratos: Lista todos os pratos disponíveis.

GET /api/pratos/{id}: Busca um prato específico pelo seu ID único.

GET /api/pratos/nome/{nome}: Busca um prato pelo seu nome.

PUT /api/pratos/{id}: Atualiza os dados de um prato existente.

DELETE /api/pratos/{id}: Remove um prato do cardápio.

Tecnologias Utilizadas
Java 21+: Linguagem de programação principal.

Spring Boot: Framework para simplificar e acelerar o desenvolvimento da aplicação.

Spring Data JPA: Abstração para o acesso ao banco de dados, utilizando o padrão JpaRepository.

MySQL: Sistema de gerenciamento de banco de dados relacional (SGBD).

Maven: Ferramenta para automação de construção e gerenciamento de dependências.

Lombok: Biblioteca que reduz a verbosidade do código, gerando automaticamente getters, setters e construtores.

Arquitetura e Padrões de Projeto
A aplicação foi construída seguindo uma arquitetura em camadas, garantindo a separação de responsabilidades e facilitando a manutenção e a escalabilidade do código.

Camada Controller: Ponto de entrada da API. Lida com as requisições e respostas HTTP, e delega a lógica de negócio para a camada de serviço.

Camada de Serviço: Contém toda a lógica de negócio do sistema. Orquestra as operações, como validação de dados, conversão de DTOs e interação com o repositório.

Camada de Repositório: Responsável pela comunicação direta com o banco de dados. Utiliza o Spring Data JPA para realizar as operações de persistência.

DTOs (Data Transfer Objects): Foram implementados DTOs (PratoRequestDTO, PratoResponseDTO) para desacoplar a API do modelo de dados interno. Isso garante que o cliente da API interaja apenas com os dados necessários, aumentando a segurança e a flexibilidade.

Principais Aprendizados
Programação Orientada a Objetos (POO): Aplicação prática de conceitos como encapsulamento e separação de responsabilidades.

Gerenciamento de Dependências: Uso de Maven para gerenciar as bibliotecas do projeto de forma eficiente.

Padrões de Design: Implementação de uma arquitetura em camadas e uso de DTOs.

Tratamento de Dados: Utilização de Optional para evitar NullPointerException e de ResponseEntity para construir respostas HTTP robustas.

Persistência de Dados: Domínio das operações de CRUD usando o Spring Data JPA.

# 🚀 Forum Hub API

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de um fórum de discussão.  
A aplicação permite criar, listar, atualizar e excluir **tópicos**, além de gerenciar **usuários e autenticação**, seguindo boas práticas de desenvolvimento backend.

Este projeto foi desenvolvido como prática de backend focado em **Spring Boot, JPA, segurança e arquitetura de APIs REST**.

---

# 📌 Funcionalidades

✔️ Cadastro de usuários  
✔️ Autenticação com Spring Security  
✔️ CRUD completo de tópicos  
✔️ Listagem e detalhamento de tópicos  
✔️ Atualização de informações  
✔️ Exclusão de tópicos  
✔️ Validação de dados  
✔️ Integração com banco de dados  
✔️ API documentada com Swagger (se estiver usando)

---

# 🛠️ Tecnologias utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Maven**
- **Flyway** (migração de banco)
- **JWT** (autenticação)
- **Swagger / OpenAPI** (documentação da API)

---

# 📂 Estrutura do Projeto


src
├── controller
├── service
├── repository
├── model
├── dto
├── security
└── config


Cada camada possui uma responsabilidade específica:

- **Controller** → Recebe as requisições HTTP  
- **Service** → Contém a lógica de negócio  
- **Repository** → Comunicação com o banco de dados  
- **DTO** → Transferência de dados entre camadas  
- **Security** → Configuração de autenticação e autorização

---

# ⚙️ Como executar o projeto

### 1️⃣ Clone o repositório

``bash
git clone https://github.com/Sg-Gabriel/Forum-Hub.git
### 2️⃣ Entre na pasta do projeto
cd Forum-Hub
### 3️⃣ Configure o banco de dados

No arquivo:

application.properties

Configure suas credenciais:

spring.datasource.url=jdbc:mysql://localhost/forumhub
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
### 4️⃣ Execute a aplicação

Via Maven:

./mvnw spring-boot:run

Ou:

mvn spring-boot:run

## 📖 Documentação da API

Após iniciar o projeto, acesse:

http://localhost:8080/swagger-ui.html

ou

http://localhost:8080/swagger-ui/index.html

## 🔑 Autenticação

A API utiliza JWT (JSON Web Token) para autenticação.

Fluxo:

Usuário faz login

Recebe um token JWT

O token deve ser enviado no header das requisições

Authorization: Bearer SEU_TOKEN

## 📌 Exemplos de endpoints
Criar tópico
POST /topicos
Listar tópicos
GET /topicos
Detalhar tópico
GET /topicos/{id}
Atualizar tópico
PUT /topicos/{id}
Deletar tópico
DELETE /topicos/{id}

🧪## Testes da API

Você pode testar os endpoints utilizando:

Postman

Insomnia

Swagger UI

## 📚 Aprendizados

Durante o desenvolvimento deste projeto foram praticados:

Construção de APIs REST

Autenticação com JWT

Arquitetura em camadas

Persistência com JPA / Hibernate

Validação de dados

Segurança com Spring Security

## 👨‍💻 Autor

Gabriel de Souza Guimarâes

GitHub
https://github.com/Sg-Gabriel

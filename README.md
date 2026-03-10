💬 Forum Hub API

API REST desenvolvida com Java e Spring Boot para gerenciamento de tópicos de um fórum.

O projeto permite que usuários autenticados criem, visualizem, atualizem e removam tópicos dentro de um sistema de discussão.

A aplicação foi desenvolvida utilizando boas práticas de desenvolvimento backend, incluindo arquitetura em camadas, autenticação com JWT, versionamento de banco com Flyway e persistência com JPA/Hibernate.

🚀 Tecnologias utilizadas

Java 17

Spring Boot

Spring Security

Spring Data JPA

Hibernate

JWT (JSON Web Token)

Flyway (migração de banco de dados)

MySQL

Maven

📂 Estrutura do Projeto
src/main/java/hub/forum/api

├── config
├── controller
├── domain
│   ├── topico
│   └── usuario
├── repository
├── security
└── service
Descrição das camadas

Controller

Responsável por receber requisições HTTP e retornar respostas da API.

Domain

Contém as entidades da aplicação e os DTOs responsáveis pela transferência de dados.

Repository

Camada responsável pela comunicação com o banco de dados utilizando Spring Data JPA.

Service

Contém a lógica de negócio da aplicação.

Security

Responsável pela autenticação e autorização utilizando Spring Security e JWT.

🔐 Autenticação

A API utiliza JWT (JSON Web Token) para autenticação.

Fluxo de autenticação:

O usuário envia login e senha

A API retorna um token JWT

O token deve ser enviado nas requisições protegidas

Exemplo de header:

Authorization: Bearer SEU_TOKEN
📌 Endpoints principais
Autenticação
Login
POST /login

Body:

{
  "login": "usuario@email.com",
  "senha": "123456"
}
Tópicos
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
⚙️ Como executar o projeto
1 Clonar o repositório
git clone https://github.com/Sg-Gabriel/Forum-Hub.git
2 Entrar na pasta
cd Forum-Hub
3 Configurar banco de dados

No arquivo:

src/main/resources/application.properties

Configure suas credenciais:

spring.datasource.url=jdbc:mysql://localhost/forumhub
spring.datasource.username=root
spring.datasource.password=sua_senha
4 Executar a aplicação
mvn spring-boot:run

A aplicação iniciará em:

http://localhost:8080
🧪 Testando a API

Ferramentas recomendadas:

Postman

Insomnia

Swagger (caso configurado)

📚 Conceitos aplicados

Durante o desenvolvimento deste projeto foram aplicados:

Desenvolvimento de APIs REST

Arquitetura em camadas

Autenticação com JWT

Segurança com Spring Security

Persistência com JPA/Hibernate

Migração de banco com Flyway

👨‍💻 Autor

Gabriel Souza

GitHub
https://github.com/Sg-Gabriel

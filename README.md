# Acervo Musical
Bem-vindo ao **Acervo Musical**, um projeto educacional desenvolvido como parte dos meus estudos em Banco de Dados e APIs RESTful na Pós-Graduação em Especialização em Java pela UTFPR.

## Descrição
O Acervo Musical é uma aplicação que gerencia um catálogo de músicas, cantores, categorias e gravadoras. O projeto inclui:
- **Backend**: Uma API RESTful construída com Java, Spring Boot e MariaDB.
- **Frontend**: Uma página web estática (HTML, CSS, JS) que consome a API e apresenta os dados.

 Este projeto foi criado por **Daniella Oliveira Rodrigues**, graduada em Análise e Desenvolvimento de Software.

## Objetivo
Demonstrar o aprendizado em:
- Desenvolvimento de APIs RESTful com Spring Boot.
- Integração com bancos de dados relacionais (MariaDB).
- Arquitetura em camadas (Entity, Repository, Service, Controller).
- Consumo de APIs via frontend.

## Estrutura do Projeto
- **Backend**: Localizado em `backend-acervo-musical-api/`, usa Spring Boot com camadas bem definidas:
  - **Entity**: Define as entidades como `Cantor`.
  - **Repository**: Comunicação com o banco via Spring Data JPA.
  - **Service**: Lógica de negócios.
  - **Controller**: Endpoints HTTP (GET, POST, PUT, DELETE).
- **Frontend**: Localizado em `frontend/`, contém HTML, CSS e JS para exibir os dados da API.
- **Tecnologias**:
  - Java 17
  - Spring Boot 3.3.1
  - MariaDB
  - HTML5, CSS3, JavaScript

## Como Rodar Localmente
### Pré-requisitos
- Java 17
- Maven
- MariaDB
- Node.js (opcional, para servir o frontend)

### Passos
1. **Configurar o Banco de Dados**:
   ```sql
   CREATE DATABASE acervo_musical;
   
Edite `backend-acervo-musical-api/src/main/resources/application.properties`:
![image](https://github.com/user-attachments/assets/86511197-8256-4ff1-ab1a-e8f2599e519d)

 2. **Rodar o Backend**:
![image](https://github.com/user-attachments/assets/c1667bb1-9875-4df1-8df8-02535619c85e)

A API estará em `http://localhost:8080`.

3. **Rodar o FrontEnd**:
![image](https://github.com/user-attachments/assets/ea30212c-81fa-46bf-8b4b-07e0db2a4a97)

Acesse em `http://localhost:3000`.

## Deploy
- **Frontend**: Hospedado no Vercel em https://acervo-musical-frontend.vercel.app.
- **Backend**: Hospedado no Railway.<br>

## Testes
Os endpoints foram testados com o Postman. Exemplo:
- `GET http://localhost:8080/cantores` - Lista todos os cantores.

## Bibliografia
- [O que é uma API RESTful? - AWS](https://aws.amazon.com/pt/what-is/restful-api/)
- [Melhores práticas para design de APIs - Microsoft](https://learn.microsoft.com/pt-br/azure/architecture/best-practices/api-design)<br>
Orientação: Prof. Esp. Hugo Baker Goveia e Esp. Adriano dos Santos Dias (UTFPR).

## Licença
© 2024 Daniella Oliveira Rodrigues - Todos os direitos reservados.

## Contato 
- **Linkedin**: [Daniella Rodrigues](www.linkedin.com/in/devdanyrodrigues)
- **Instagram**: [Dev Dany Oliver](https://www.instagram.com/dev_danyoliver/)

  
















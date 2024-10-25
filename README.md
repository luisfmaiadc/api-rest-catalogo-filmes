<h1 align="center">Projeto API REST - Catálogo de Filmes</h1>
<p align="center">
 <a href="#started">Começando</a> • 
  <a href="#cloning">Clonando</a> •
 <a href="#creating">Banco de Dados</a> •
 <a href="#routes">API Endpoints</a> •
 <a href="#colab">Colaboradores</a>
</p>

<p align="center" style="margin-bottom: 20;">
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
    <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring" />
    <img src="https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL" />
    <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white" alt="Hibernate" />
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" alt="Apache Maven" />
    <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white" alt="Postman" />
</p>

<p style="text-align: justify;">Este projeto é uma API REST desenvolvida com Spring Boot 3.3.4 e Java 21, que realiza operações CRUD (Create, Read, Update, Delete) em um Catálogo de Filmes armazenado em um banco de dados MySQL. Utilizei JPA com o Hibernate como provedor de persistência para o mapeamento objeto-relacional.</p>

<h2 id="started">🚀 Começando</h2>

Antes de começar, verifique se você possui as seguintes ferramentas instaladas em sua máquina:

- [Java](https://www.oracle.com/java/technologies/downloads/#java22)
- [MySQL](https://dev.mysql.com/downloads/installer/)
- [Postman](https://www.postman.com/downloads/)

<h2 id="cloning">👾 Clonando</h2>

Como clonar o projeto:
```bash
git@github.com:luisfmaiadc/api-rest-catalogo-filmes.git
```

<h2 id="creating">💾 Criando Banco de Dados</h2>
<p style="margin-bottom: 20;">Para que o projeto funcione corretamente, é necessário criar um banco de dados MySQL com o nome <i>dbFilme</i> a partir do comando abaixo:</p>


```SQL
CREATE DATABASE dbFilme;
```

<p style="margin-top: 20;">Não é necessário se preocupar com a criação da tabela FILME manualmente, pois estou utilizando o Flyway para gerenciar as migrações do banco de dados. Assim, ao rodar o projeto, a tabela será criada automaticamente.</p>

A tabela deve conter os seguintes campos:

- <b>id:</b> chave primária, auto-incrementada pelo banco de dados
- <b>titulo:</b> campo de texto (String) com até 300 caracteres
- <b>diretor:</b> campo de texto (String) com até 150 caracteres
- <b>genero:</b> campo de texto (String) com até 100 caracteres
- <b>ano_lancamento:</b> campo do tipo year

<h2 id="routes">📍 API Endpoints</h2>

A API oferece os seguintes endpoints para realizar as operações de CRUD no catálogo de filmes:
​
| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /filmes</kbd>     | Retorna a lista de todos os filmes cadastrados no banco de dados. [response details](#get-filmes)
| <kbd>GET /filmes/{genero}</kbd>     | Retorna uma lista de filmes a partir de seu genêro. [response details](#get-filmes-genero)
| <kbd>POST /filmes</kbd>     | Adiciona um novo filme ao catálogo. É necessário fornecer os dados do filme no corpo da requisição no formato JSON. [request details](#post-filmes)
| <kbd>PUT /filmes/{id}</kbd>     | Atualiza as informações de um filme existente. A requisição deve conter o ID do filme e os novos dados no corpo, no formato JSON. [request details](#put-filmes)
| <kbd>DELETE /filmes/{id}</kbd>     | Exclui um filme do catálogo, buscando pelo seu ID que é fornecido via URL.

<h3 id="get-filmes">GET /filmes</h3>

**RESPONSE**
```json
[
    {
        "titulo": "Ratatouille",
        "diretor": "Brad Bird",
        "genero": "ANIMACAO",
        "anoLancamento": 2007
    },
    {
        "titulo": "10 Coisas que Eu Odeio em Você",
        "diretor": "Gil Junger",
        "genero": "ROMANCE",
        "anoLancamento": 1999
    }
]
```

<h3 id="get-filmes-genero">GET /filmes/{genero}</h3>

**RESPONSE**
```json
[
    {
        "titulo": "10 Coisas que Eu Odeio em Você",
        "diretor": "Gil Junger",
        "genero": "ROMANCE",
        "anoLancamento": 1999
    },
    {
        "titulo": "Amizade Colorida",
        "diretor": "Will Gluck",
        "genero": "ROMANCE",
        "anoLancamento": 2011
    }
]
```

<h3 id="post-filmes">POST /filmes</h3>

**REQUEST**
```json
{
  "titulo": "Nome do Filme",
  "diretor": "Nome do Diretor",
  "genero": "ENUM",
  "anoLancamento": 2024
}
```

<h3 id="put-filmes">PUT /filmes/{id}</h3>

**REQUEST**
```json
{
  "id": 4,  
  "anoLancamento": 2007
}
```

<b>Obs.</b> Para validar o funcionamento da API, utilizei o Postman para realizar requisições e verificar as respostas dos endpoints.

<h2 id="colab">🤝 Colaboradores</h2>
<p style="margin-bottom: 20;">Este projeto foi desenvolvido por mim e marca minha primeira experiência na criação de uma API REST. Foi uma jornada enriquecedora que contribuiu para meu crescimento como desenvolvedor.</p>
<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/168129517?v=4&size=64" width="100px;" alt="Luis Felipe Maia da Costa Profile Picture"/><br>
        <sub>
          <b>Luis Felipe Maia da Costa</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
# 📌 API de Gerenciamento de Contatos

![GitHub repo size](https://img.shields.io/github/repo-size/iuricode/README-template?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/iuricode/README-template?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/iuricode/README-template?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/iuricode/README-template?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/iuricode/README-template?style=for-the-badge)

## 📌 Sobre o Projeto

A API de Controle de Contatos foi desenvolvida para gerenciar relações entre pessoas e seus contatos, permitindo operações de CRUD (Create, Read, Update, Delete). Este projeto foi criado como parte de um processo de capacitação da Minsait e é ideal para ser integrado a sistemas de gerenciamento de contatos, aplicações web e outras soluções que necessitem de controle de informações de contato.


---

## 🚀 Tecnologias Utilizadas

- **Java** (JDK 21)
- **Spring Boot**
- **Maven** para gerenciamento de dependências
- **Banco de Dados**  MySQL
- **Spring Data JPA** para persistência de dados
- **Swagger (SpringDoc OpenAPI)** para documentação da API
- **Spring Boot Starter Validation** para validação de dados

---

## 💻 Pré-requisitos

Antes de começar, certifique-se de que atende aos seguintes requisitos:

- **JDK 21** instalado e configurado no ambiente.
- **Maven** instalado para baixar dependências e compilar o projeto.
- **IDE** recomendada: IntelliJ IDEA ou outra compatível com Java.
- **MySQL** Instale e configure o banco de dados.

---

## 📦 Instalação e Execução

1. 🔹 **Clonar o repositório**
 

   git clone https://github.com/BrayanFj/API-Rest-para-Controle-de-Contatos.git
   cd API-Rest-para-Controle-de-Contatos


2. 🔹 **Abra o Projeto na IDE:**
   Importe o projeto utilizando sua IDE preferida e configure o uso da JDK 21

3. 🔹 **Configurar o Banco de Dados**
   Edite o arquivo application.properties ou application.yml para configurar as credenciais do MySQL:

  spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.jpa.hibernate.ddl-auto=update


4. 🔹 **Baixe as Dependências:**
   ```bash
   mvn clean install
   ```

5. 🔹 **Inicie a Aplicação:**
   ```bash
   mvn spring-boot:run
   ```

6. 🔹 **Acesse a API:**
    - API: [http://localhost:8080](http://localhost:8080)
    - Swagger UI (Documentação): [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---


## 📁 Estrutura do Projeto 

A estrutura de diretórios segue o padrão MVC:

- **models** → Classes que representam as entidades do domínio.
- **controllers** → Recebem requisições HTTP e direcionam para os serviços.
- **services** → Contém a lógica de negócio da aplicação.
- **repositories** → Interfaces para persistência de dados.
- **dtos** → Transferência de dados entre as camadas.
- **exceptions** → Tratamento de exceções personalizadas.

---

### 🛠️ Ajustes e melhorias

O projeto ainda está em desenvolvimento e rebera nvas atualizações 

- [x] Tarefa 1 - CRUD para pessoas e contatos (Atividade Avaliativa)
- [] Tarefa 2 - Integração com Front-end criado/ensinado em aula.
- [] Tarefa 3 - Novas funcionalidades. 

---

## 🤝 Contribuição

Contribuições são bem-vindas! Caso deseje contribuir:

1. **Issues:** Abra uma _issue_ para sugerir melhorias ou reportar bugs.
2. **Pull Requests:** Envie suas contribuições por meio de _pull requests_.  
3.  **Observação:** Os commits devem seguir as convenções em inglês, utilizando prefixos como `feat:`, `fix:` e `wip:`.

**Os commits devem seguir a convenção:**
- `feat:` para novas funcionalidades
- `fix:` para correções de bugs
- `docs:` para documentação
- `test:` para inclusão de testes

---

## 📝 Licença

Este projeto está sob licença **MIT**. Veja o arquivo [LICENSE](LICENSE.md) para mais detalhes.

---

## 📫 Créditos e Contato
-- 👨‍💻 **Desenvolvido por:** Brayan Fernandes
- **LinkedIn:** [Brayan Fernandes ]([https://www.linkedin.com/in/seu-perfil/](https://www.linkedin.com/in/brayanfernandesj/))
- **Email:** [seu.email@gmail.com](Brayan.fernandesjulio@gmail.com)


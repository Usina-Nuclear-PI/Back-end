# ⚙️ NUCLENAI — API Back-end (`api_pi`)

API RESTful desenvolvida em **Java 17** com **Spring Boot** e **Spring Data JPA**, responsável por prover os endpoints de autenticação, gerenciamento de usuários, domínios operacionais e registros de telemetria da usina nuclear **NUCLENAI**.

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 4.1.1** (Spring Web MVC & Spring Data JPA)
* **MySQL** (MySQL Connector/J)
* **Maven** (com Maven Wrapper incluído)

## 📁 Estrutura do Projeto

```text
api_pi/src/main/java/br/com/usina/api_pi/
├── config/
│   └── CorsConfig.java              # Configuração global de CORS
├── controller/
│   ├── ArquivosController.java      # Endpoints de upload/gestão de arquivos (/arquivos)
│   ├── CircuitosController.java     # CRUD de circuitos (/circuitos)
│   ├── MonitoramentoController.java # CRUD de medições e telemetria (/monitoramento)
│   ├── StatusController.java        # CRUD de status operacionais (/status)
│   ├── TurnosController.java        # CRUD de turnos (/turnos)
│   └── UsuariosController.java      # Autenticação e CRUD de usuários (/usuarios)
├── model/                           # Entidades JPA mapeadas para o banco pi_usina
└── repository/                      # Interfaces Spring Data JPA
```

## 🔌 Principais Endpoints

| Recurso | Base URL | Métodos Suportados | Descrição |
| :--- | :--- | :--- | :--- |
| **Autenticação** | `/usuarios/login` | `POST` | Valida credenciais (`email` e `senha`) e retorna dados do usuário |
| **Usuários** | `/usuarios` | `GET`, `POST`, `PUT`, `DELETE` | Gerenciamento de operadores e administradores |
| **Monitoramento** | `/monitoramento` | `GET`, `POST`, `PUT`, `DELETE` | Consulta e registro de medições dos sensores da usina |
| **Circuitos** | `/circuitos` | `GET`, `POST`, `PUT`, `DELETE` | Gerenciamento dos circuitos operacionais |
| **Turnos** | `/turnos` | `GET`, `POST`, `PUT`, `DELETE` | Gerenciamento dos turnos de trabalho |
| **Status** | `/status` | `GET`, `POST`, `PUT`, `DELETE` | Gerenciamento dos estados operacionais |
| **Arquivos** | `/arquivos` | `GET`, `POST`, `PUT`, `DELETE` | Registro e consulta de arquivos de importação (`LONGBLOB`) |

## 🚀 Como Executar Localmente

1. **Configure o Banco de Dados**:
   Ajuste as credenciais do MySQL em `src/main/resources/application.properties` (ou utilize variáveis de ambiente em produção):
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/pi_usina
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```
2. **Execute a aplicação via Maven Wrapper**:
   ```bash
   ./mvnw spring-boot:run
   ```
   *(No Windows, utilize `mvnw.cmd spring-boot:run`)*

A API iniciará por padrão em `http://localhost:8080`.
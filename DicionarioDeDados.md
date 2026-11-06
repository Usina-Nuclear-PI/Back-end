# 📚 Dicionário de Dados — Sistema de Monitoramento de Usina

> Documentação técnica da estrutura do banco de dados `pi_usina`, detalhando a tabela principal de medições e suas respectivas tabelas de suporte.

---

## 📋 Tabela: `monitoramento`
Esta é a tabela principal do sistema, responsável por armazenar todas as medições físico-químicas e operacionais coletadas na usina.

| Campo | Tipo | Tamanho | Obrigatório | Regra / Descrição |
| :--- | :---: | :---: | :---: | :--- |
| **`id_registro`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔑 **PK / Auto Increment**<br>Identificador único do registro. Serve para diferenciar uma medição das demais.<br>_Exemplo:_ `100245` |
| **`data_hora`** | `DATETIME` | 8 Bytes | 🟢 **Sim** | 📅 Data e horário exatos em que a medição foi realizada. Utilizado para acompanhar a evolução dos parâmetros ao longo do tempo.<br>_Exemplo:_ `2026-09-10 14:30:00` |
| **`id_circuito`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔗 **FK** $
ightarrow$ `circuitos(id)`<br>Identifica qual área, sistema ou circuito da instalação está sendo monitorado.<br>_Exemplo:_ `Circuito Primário`, `Sistema de Resfriamento` |
| **`id_turno`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔗 **FK** $
ightarrow$ `turnos(id)`<br>Indica o turno de operação em que a medição ocorreu.<br>_Exemplo:_ `Manhã`, `Tarde`, `Noite` ou `Turno A`, `Turno B` |
| **`id_status`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔗 **FK** $
ightarrow$ `status_operacional(id)`<br>Indica a situação operacional do sistema no momento da medição.<br>_Exemplo:_ `Normal`, `Manutenção`, `Alerta`, `Parada` |
| **`temperatura_c`** | `DECIMAL` | (10, 2) | ⚪ **Não** | 🌡️ Temperatura medida no circuito, em graus Celsius (°C). Acompanha o comportamento térmico do sistema. |
| **`pressao_bar`** | `DECIMAL` | (10, 2) | ⚪ **Não** | ⏲️ Pressão medida no circuito, em bar. Indicador importante das condições de operação. |
| **`vazao_m3_h`** | `DECIMAL` | (10, 2) | ⚪ **Não** | 💧 Quantidade de fluido que passa pelo circuito por hora, em $m^3/h$. Verifica se a circulação do fluido ocorre adequadamente. |
| **`potencia_mw`** | `DECIMAL` | (10, 2) | ⚪ **Não** | ⚡ Potência associada à operação ou geração, em megawatts (MW). Representa a potência produzida ou operacional do sistema. |
| **`radiacao_msv_h`** | `DECIMAL` | (10, 4) | ⚪ **Não** | ☢️ Nível de radiação medido em milisieverts por hora (mSv/h). Monitoramento radiológico conforme limites e procedimentos aplicáveis. |
| **`vibracao_mm_s`** | `DECIMAL` | (10, 2) | ⚪ **Não** | 〰️ Nível de vibração dos equipamentos rotativos, em mm/s. Identifica alterações no comportamento mecânico de bombas, turbinas, etc. |
| **`nivel_refrigerante_pct`** | `DECIMAL` | (5, 2) | ⚪ **Não** | 🧪 Percentual do nível disponível de fluido refrigerante.<br>_Exemplo:_ `95.50` representa 95,5% do nível de referência. |
| **`eficiencia_termica_pct`** | `DECIMAL` | (5, 2) | ⚪ **Não** | ⚙️ Eficiência térmica do processo, expressa em percentual. Indica quanta energia térmica é convertida de forma útil. |
| **`id_arquivo`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔗 **FK** $
ightarrow$ `arquivo_importacao(id)`<br>📁 Identifica de qual arquivo os dados daquele registro foram obtidos. |
| **`id_usuario`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔗 **FK** $
ightarrow$ `usuarios(id)`<br>👤 Identifica quem ou qual sistema realizou a importação desses dados para o banco de dados. |

---

## 🗂️ Tabelas Auxiliares (Domínio e Relacionamentos)

### 👤 Tabela: `usuarios`
Armazena os usuários cadastrados no sistema que possuem permissão para realizar importações.

| Campo | Tipo | Tamanho | Obrigatório | Regra / Descrição |
| :--- | :---: | :---: | :---: | :--- |
| **`id`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔑 **PK / Auto Increment** — Identificador único do usuário. |
| **`nome`** | `VARCHAR` | 255 char | 🟢 **Sim** | Nome completo do usuário cadastrado. |
| **`email`** | `VARCHAR` | 255 char | 🟢 **Sim** | Endereço de e-mail corporativo. |
| **`senha`** | `CHAR` | 12 char | 🟢 **Sim** | Senha encriptada/hash do usuário. |

---

### 📂 Tabela: `arquivo_importacao`
Registra o histórico de arquivos importados e guarda seu conteúdo binário.

| Campo | Tipo | Tamanho | Obrigatório | Regra / Descrição |
| :--- | :---: | :---: | :---: | :--- |
| **`id`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔑 **PK / Auto Increment** — Identificador único do arquivo importado. |
| **`id_usuario`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔗 **FK** $
ightarrow$ `usuarios(id)` — Usuário responsável pelo upload. |
| **`nome`** | `VARCHAR` | 255 char | 🟢 **Sim** | Nome original do arquivo. |
| **`descricao`** | `VARCHAR` | 255 char | ⚪ **Não** | Observações ou descrição opcional do lote de dados. |
| **`arquivo`** | `BLOB` | Variável | 🟢 **Sim** | Conteúdo binário original armazenado. |

---

### 🔄 Tabela: `circuitos`
| Campo | Tipo | Tamanho | Obrigatório | Regra / Descrição |
| :--- | :---: | :---: | :---: | :--- |
| **`id`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔑 **PK / Auto Increment** — Identificador do circuito. |
| **`nome`** | `VARCHAR` | 255 char | 🟢 **Sim** | Nome da área ou circuito monitorado (ex: *Circuito Primário*). |

---

### ⏰ Tabela: `turnos`
| Campo | Tipo | Tamanho | Obrigatório | Regra / Descrição |
| :--- | :---: | :---: | :---: | :--- |
| **`id`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔑 **PK / Auto Increment** — Identificador do turno. |
| **`nome`** | `VARCHAR` | 100 char | 🟢 **Sim** | Denominação do turno operacional (ex: *Manhã*, *Turno A*). |

---

### 🚦 Tabela: `status_operacional`
| Campo | Tipo | Tamanho | Obrigatório | Regra / Descrição |
| :--- | :---: | :---: | :---: | :--- |
| **`id`** | `INT` | 4 Bytes | 🟢 **Sim** | 🔑 **PK / Auto Increment** — Identificador do status. |
| **`descricao`** | `VARCHAR` | 100 char | 🟢 **Sim** | Descrição do estado (ex: *Normal*, *Alerta*, *Parada*). |

---

> 💡 **Nota Técnica:** Para manter a integridade dos dados, as chaves estrangeiras (`FK`) contam com restrições de integridade referencial apontando para suas respectivas tabelas primárias.
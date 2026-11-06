create database pi_usina;

use pi_usina;

create table usuarios
(
	id int auto_increment not null primary key,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha char(12) not null
);

CREATE TABLE arquivo_importacao(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    arquivo BLOB NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE circuitos
(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE turnos
(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE status_operacional
(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL
);

CREATE TABLE monitoramento
(
    id_registro INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    data_hora DATETIME NOT NULL,

    id_circuito INT NOT NULL,
    id_turno INT NOT NULL,
    id_status INT NOT NULL,

    temperatura_c DECIMAL(10,2),
    pressao_bar DECIMAL(10,2),
    vazao_m3_h DECIMAL(10,2),
    potencia_mw DECIMAL(10,2),
    radiacao_msv_h DECIMAL(10,4),
    vibracao_mm_s DECIMAL(10,2),
    nivel_refrigerante_pct DECIMAL(5,2),
    eficiencia_termica_pct DECIMAL(5,2),

    id_arquivo INT NOT NULL,
    id_usuario INT NOT NULL,

    FOREIGN KEY (id_circuito)
        REFERENCES circuitos(id),

    FOREIGN KEY (id_turno)
        REFERENCES turnos(id),

    FOREIGN KEY (id_status)
        REFERENCES status_operacional(id),

    FOREIGN KEY (id_arquivo)
        REFERENCES arquivos_origem(id),

    FOREIGN KEY (id_usuario)
        REFERENCES usuarios(id)
);

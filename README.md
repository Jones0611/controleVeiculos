README - Sistema de Controle de Veículos
Tela Principal do Sistema

📌 Visão Geral
Sistema de gerenciamento de frota veicular desenvolvido em Java com interface Swing e banco de dados MySQL. Permite o CRUD completo de veículos com controle de status (Disponível, Alugado, Em manutenção) e tipos (Carro, Caminhão, Moto).

✨ Funcionalidades
Cadastro de veículos com todos os dados relevantes (placa, marca, modelo, etc.)

Pesquisa por placa do veículo

Atualização de informações cadastrais

Exclusão de veículos da base

Consulta geral filtrada por tipo e status

Sistema de login para controle de acesso

🛠 Tecnologias Utilizadas
Linguagem: Java 8+

Interface Gráfica: Java Swing

Banco de Dados: MySQL

Padrão de Projeto: DAO (Data Access Object)

Gerenciamento de Dependências: Maven

Outras Bibliotecas: JDBC, JOptionPane

📋 Pré-requisitos
Java JDK 8 ou superior

MySQL Server 5.7+

IDE de preferência (Eclipse, IntelliJ, NetBeans)

Maven (para gerenciamento de dependências)

🚀 Como Executar
Configurar o banco de dados:

sql
CREATE DATABASE controle_frota;
USE controle_frota;

CREATE TABLE veiculos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    placa VARCHAR(10) NOT NULL UNIQUE,
    anodesc VARCHAR(20),
    tipo ENUM('carro', 'caminhao', 'moto') NOT NULL,
    status ENUM('disponivel', 'alugado', 'manutencao') NOT NULL
);

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL
);
Configurar conexão com o banco:

Editar a classe Conexao.java com seus dados de acesso ao MySQL

Executar o projeto:

Via IDE: Executar a classe Login.java como aplicação Java

Via linha de comando:

bash
mvn clean install
java -jar target/controle-veiculos.jar
🖼 Screenshots
Tela de Login

Tela Principal	Tela de Pesquisa
Login	Main	Search
Tela de Cadastro	Tela de Atualização	Consulta Geral
Register	Update	Query

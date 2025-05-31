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
![image](https://github.com/user-attachments/assets/01d0e5be-5fb3-40e9-9205-4f95e28618e1)
![image](https://github.com/user-attachments/assets/04127c3c-a32b-48c9-b1e6-8013c7244010)
![image](https://github.com/user-attachments/assets/6c9ddbcd-8d8e-4796-b6c2-28447eac7fc6)
![image](https://github.com/user-attachments/assets/99437780-39d1-4df3-9e85-085d9aca57bf)
![image](https://github.com/user-attachments/assets/7198b43d-48bb-48d2-93c0-d7e08bc35673)
![image](https://github.com/user-attachments/assets/81537f57-171f-468d-b686-f54b71ee2916)
![image](https://github.com/user-attachments/assets/88795df9-37a2-449d-943d-254595b92f75)


🧩 Estrutura do Projeto
mvc-veiculos/
├── src/
│   ├── Controller/
│   │   ├── Conexao.java       # Gerencia conexão com o banco
│   │   └── DAO.java           # Padrão Data Access Object
│   ├── Model/
│   │   ├── Usuario.java       # Entidade usuário
│   │   └── Veiculo.java       # Entidade veículo
│   └── View/
│       ├── Login.java         # Tela de autenticação
│       ├── TelaPrincipal.java # Menu principal
│       ├── Pesquisar.java     # Tela de pesquisa
│       ├── Alterar.java       # Tela de edição
│       ├── Delete.java        # Tela de exclusão
│       ├── ConsultarTodos.java# Listagem completa
│       ├── CadastroUser.java  # Cadastro de usuários
│       ├── lupa2.png          # Ícone de pesquisa
│       └── lupa3.png          # Ícone alternativo
└── mvc/
    └── MVC.java               # Ponto de entrada

🧠 Arquitetura MVC
Model (Modelo)
Veiculo.java: Classe que representa a entidade veículo com atributos e métodos getters/setters

Usuario.java: Classe que representa a entidade usuário do sistema

View (Visão)
Telas Swing (Login.java, TelaPrincipal.java, etc.)

Responsável pela interface gráfica e interação com usuário

Ícones e recursos visuais

Controller (Controle)
DAO.java: Padrão Data Access Object para operações CRUD

Conexao.java: Gerencia conexão com banco de dados MySQL

🛠️ Como Executar (Atualizado)
Importe o projeto na sua IDE como projeto Maven existente

Configure o banco conforme instruções anteriores

Execute a classe mvc.MVC.java como aplicação Java

🔄 Fluxo MVC
View coleta interação do usuário

Controller (DAO.java) processa solicitações

Model acessa e manipula dados no banco

Controller retorna resultados para View

View atualiza a interface

📦 Dependências Maven
Adicione ao seu pom.xml:

xml
<dependencies>
    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.28</version>
    </dependency>
</dependencies>
🆚 Comparação com Versão Anterior
Melhoria	Versão Atual (MVC)	Versão Anterior
Organização	Pacotes MVC claros	Estrutura plana
Acoplamento	Baixo (camadas separadas)	Alto
Manutenibilidade	Fácil extensão	Difícil modificação
Reúso de código	Componentes reaproveitáveis	Código duplicado

📌 Boas Práticas Implementadas
Separação clara entre lógica de negócio, dados e interface

Nomes significativos para classes e métodos

Tratamento de erros em operações de banco

Documentação de classes principais

Padrão DAO para isolamento do acesso a dados

🚀 Próximos Passos (Sugestões)
Adicionar VeiculoController.java para intermediar View e Model

Implementar VeiculoService.java para regras de negócio

Criar testes unitários para cada camada

Adicionar validações na View

Implementar padrão Observer para atualizações em tempo real

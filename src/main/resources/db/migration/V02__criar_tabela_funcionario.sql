CREATE TABLE funcionario (
	codigo serial PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(30),
	cpf varchar(14),
	rg varchar(30),
	numero_certidao_nascimento varchar(40),
	justificativa_documento varchar(100),
	data_nascimento date,
	sexo varchar(20),
	cor_raca varchar(50),
	nome_filiacao_resonsavel_1 varchar(50),
	nome_filiacao_resonsavel_2 varchar(50),
	sobre_nome_filiacao_resonsavel_1 varchar(50),
	sobre_nome_filiacao_resonsavel_2 varchar(50),
	deficiencia varchar(3),
	tipo_deficiencia varchar(50),
	observacao varchar(80),
	telefone varchar(20),
	celular varchar(20),
	nis varchar(50),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL,
	
	cracha varchar(32),
	funcao_funcionario varchar(50) not null,
	nivel_escolar varchar(50) not null,
	tipo_ensino_medio_cursando varchar(50)

);



INSERT INTO funcionario (nome, sobrenome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo,funcao_funcionario,nivel_escolar,tipo_ensino_medio_cursando,codigo) 
values ('João', 'Silva', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true,
'Atendente','Ensino medio ','Profissionalizante',1);

INSERT INTO funcionario (nome, sobrenome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo,funcao_funcionario,nivel_escolar,tipo_ensino_medio_cursando,codigo) 
values ('Maria', 'Rita', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', true,
'Professor','Ensino Superior ','Medio Normal',2);

INSERT INTO funcionario (nome, sobrenome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo,funcao_funcionario,nivel_escolar,tipo_ensino_medio_cursando,codigo) 
values ('Pedro', 'Santos', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true,
'Faxineiro','Ensino fundamental ','Profissionalizante',3);

CREATE TABLE aluno (
	codigo bigint NOT NULL,
    ativo boolean,
    celular character varying(255) ,
    cor_raca character varying(255) ,
    cpf character varying(255) ,
    data_nascimento timestamp without time zone,
    deficiencia character varying(255) ,
    bairro character varying(255) ,
    cep character varying(255) ,
    cidade character varying(255) ,
    complemento character varying(255) ,
    estado character varying(255) ,
    logradouro character varying(255) ,
    numero character varying(255) ,
    justificativa_documento character varying(255) ,
    nis character varying(255) ,
    nome character varying(255) NOT NULL,
    nome_filiacao_resonsavel_1 character varying(255) ,
    nome_filiacao_resonsavel_2 character varying(255) ,
    numero_certidao_nascimento character varying(255) ,
    observacao character varying(255) ,
    rg character varying(255) ,
    sexo character varying(255) ,
    sobre_nome character varying(255) ,
    sobre_nome_filiacao_resonsavel_1 character varying(255) ,
    sobre_nome_filiacao_resonsavel_2 character varying(255) ,
    telefone character varying(255) ,
    tipo_deficiencia character varying(255) ,
    matricula character varying(255) ,
    CONSTRAINT aluno_pkey PRIMARY KEY (codigo)
    
	
);

INSERT INTO aluno(
	codigo, ativo, celular, cor_raca, cpf, data_nascimento, deficiencia, bairro, cep, cidade, 
	complemento, estado, logradouro, numero, justificativa_documento, nis, nome, nome_filiacao_resonsavel_1, 
	nome_filiacao_resonsavel_2, numero_certidao_nascimento, observacao, rg, sexo, sobre_nome, 
	sobre_nome_filiacao_resonsavel_1, sobre_nome_filiacao_resonsavel_2, telefone, tipo_deficiencia, matricula)
	VALUES (1, true, '(21) 97677-8690', 'BRANCA', '123.897.110-09', '01/12/1999', null, 
	null, null, null, null, null, null, null, null, null, 'Cleber', null, null, null, null, null, null, 'Dos Santos', 
	null, null, null, null, null);
	
INSERT INTO aluno(
	codigo, ativo, celular, cor_raca, cpf, data_nascimento, deficiencia, bairro, cep, cidade, 
	complemento, estado, logradouro, numero, justificativa_documento, nis, nome, nome_filiacao_resonsavel_1, 
	nome_filiacao_resonsavel_2, numero_certidao_nascimento, observacao, rg, sexo, sobre_nome, 
	sobre_nome_filiacao_resonsavel_1, sobre_nome_filiacao_resonsavel_2, telefone, tipo_deficiencia, matricula)
	VALUES (2, true, '(11) 97877-1190', 'BRANCA', '111.897.110-09', '01/12/2002', null, 
	null, null, null, null, null, null, null, null, null, 'Rita', null, null, null, null, null, null, 'Maria', 
	null, null, null, null, null);
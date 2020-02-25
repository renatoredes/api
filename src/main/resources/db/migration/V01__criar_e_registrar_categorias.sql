CREATE TABLE categoria
(
    codigo serial PRIMARY KEY,
    nome character varying(20) NOT NULL,
    receitas character varying(20),
    despesas character varying(20),
    contas character varying(20) ,
    servicos character varying(20)   
   
);
INSERT INTO categoria(nome, receitas, despesas, contas, servicos)
	VALUES ('exemplo1', 'exemplo2', 'exemplo3', 'exemplo4', 'exemplo5');
	

INSERT INTO categoria(nome, receitas, despesas, contas, servicos)
	VALUES ('exemplo1', 'exemplo2', 'exemplo3', 'exemplo4', 'exemplo5');
	

INSERT INTO categoria(nome, receitas, despesas, contas, servicos)
	VALUES ('exemplo1', 'exemplo2', 'exemplo3', 'exemplo4', 'exemplo5');
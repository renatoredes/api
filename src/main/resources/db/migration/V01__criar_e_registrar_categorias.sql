CREATE TABLE categoria (
	codigo serial PRIMARY KEY,
	nome VARCHAR(50) NOT NULL
);

INSERT INTO categoria (nome) values ('exemplo-01');
INSERT INTO categoria (nome) values ('exemplo-02');
INSERT INTO categoria (nome) values ('exemplo-03');
INSERT INTO categoria (nome) values ('exemplo-04');
INSERT INTO categoria (nome) values ('Outros');
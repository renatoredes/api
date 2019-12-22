/*==============================================================*/
/* DBMS name:      PostgreSQL 7.3                               */
/* Created on:     22/12/2019 16:15:30                          */
/*==============================================================*/


drop index PESSOAALUNO2_FK;

drop index CONTRATOALUNO2_FK;

drop index ALUNO_PK;

drop table ALUNO;

drop index CONTRATOALUNO_FK;

drop index CONTRATO_PK;

drop table CONTRATO;

drop index CURSO_PK;

drop table CURSO;

drop index ENDERECO_PK;

drop table ENDERECO;

drop index PESSOAFUNCIONARIO2_FK;

drop index FUNCIONARIO_PK;

drop table FUNCIONARIO;

drop index MATRICULAALUNO_FK;

drop index MATRICULACURSO_FK;

drop index MATRICULA_PK;

drop table MATRICULA;

drop index PESSOAPROFESSOR_FK;

drop index PESSOAALUNO_FK;

drop index PESSOAFUNCIONARIO_FK;

drop index PESSOAENDERECO_FK;

drop index PESSOA_PK;

drop table PESSOA;

drop index PESSOAPROFESSOR2_FK;

drop index PROFESSOR_PK;

drop table PROFESSOR;

drop index CURSOTURMA_FK;

drop index TURMA_PK;

drop table TURMA;

/*==============================================================*/
/* Table: ALUNO                                                 */
/*==============================================================*/
create table ALUNO (
CODIGO_ALUNO         INT8                 not null,
CODIGO_PESSOA        INT8                 not null,
CODIGO_CONTRATO      INT8                 null,
constraint PK_ALUNO primary key (CODIGO_ALUNO)
);

/*==============================================================*/
/* Index: ALUNO_PK                                              */
/*==============================================================*/
create unique index ALUNO_PK on ALUNO (
CODIGO_ALUNO
);

/*==============================================================*/
/* Index: CONTRATOALUNO2_FK                                     */
/*==============================================================*/
create  index CONTRATOALUNO2_FK on ALUNO (
CODIGO_CONTRATO
);

/*==============================================================*/
/* Index: PESSOAALUNO2_FK                                       */
/*==============================================================*/
create  index PESSOAALUNO2_FK on ALUNO (
CODIGO_PESSOA
);

/*==============================================================*/
/* Table: CONTRATO                                              */
/*==============================================================*/
create table CONTRATO (
CODIGO_CONTRATO      INT8                 not null,
CODIGO_ALUNO         INT8                 null,
DATA_VENCIMENTO      DATE                 null,
DATA_CONTRATO        DATE                 null,
SITUACAO_CONTRATO    VARCHAR(20)          null,
DESCRICAO            TEXT                 null,
VALOR_CONTRATO       DECIMAL              null,
constraint PK_CONTRATO primary key (CODIGO_CONTRATO)
);

/*==============================================================*/
/* Index: CONTRATO_PK                                           */
/*==============================================================*/
create unique index CONTRATO_PK on CONTRATO (
CODIGO_CONTRATO
);

/*==============================================================*/
/* Index: CONTRATOALUNO_FK                                      */
/*==============================================================*/
create  index CONTRATOALUNO_FK on CONTRATO (
CODIGO_ALUNO
);

/*==============================================================*/
/* Table: CURSO                                                 */
/*==============================================================*/
create table CURSO (
CODIGO_CURSO         INT8                 not null,
NOME_CURSO           VARCHAR(100)         null,
PERIODO_CURSO        CHAR(1)              null,
NIVEL_CURSO          VARCHAR(100)         null,
OBSERVACAO           TEXT                 null,
SERIE_INICIO         CHAR(1)              null,
SERIE_FINAL          CHAR(1)              null,
constraint PK_CURSO primary key (CODIGO_CURSO)
);

/*==============================================================*/
/* Index: CURSO_PK                                              */
/*==============================================================*/
create unique index CURSO_PK on CURSO (
CODIGO_CURSO
);

/*==============================================================*/
/* Table: ENDERECO                                              */
/*==============================================================*/
create table ENDERECO (
CODIGO_ENDERECO      INT8                 not null,
CEP                  VARCHAR(20)          null,
RUA                  VARCHAR(50)          null,
BAIRRO               VARCHAR(50)          null,
CIDADE               VARCHAR(50)          null,
ESTADO               VARCHAR(50)          null,
PAIS                 VARCHAR(50)          null,
constraint PK_ENDERECO primary key (CODIGO_ENDERECO)
);

/*==============================================================*/
/* Index: ENDERECO_PK                                           */
/*==============================================================*/
create unique index ENDERECO_PK on ENDERECO (
CODIGO_ENDERECO
);

/*==============================================================*/
/* Table: FUNCIONARIO                                           */
/*==============================================================*/
create table FUNCIONARIO (
CODIGO_FUNCIONARIO   INT8                 not null,
CODIGO_PESSOA        INT8                 not null,
constraint PK_FUNCIONARIO primary key (CODIGO_FUNCIONARIO)
);

/*==============================================================*/
/* Index: FUNCIONARIO_PK                                        */
/*==============================================================*/
create unique index FUNCIONARIO_PK on FUNCIONARIO (
CODIGO_FUNCIONARIO
);

/*==============================================================*/
/* Index: PESSOAFUNCIONARIO2_FK                                 */
/*==============================================================*/
create  index PESSOAFUNCIONARIO2_FK on FUNCIONARIO (
CODIGO_PESSOA
);

/*==============================================================*/
/* Table: MATRICULA                                             */
/*==============================================================*/
create table MATRICULA (
CODIGO_MATRICULA     INT8                 not null,
CODIGO_ALUNO         INT8                 not null,
CODIGO_CURSO         INT8                 null,
constraint PK_MATRICULA primary key (CODIGO_MATRICULA)
);

/*==============================================================*/
/* Index: MATRICULA_PK                                          */
/*==============================================================*/
create unique index MATRICULA_PK on MATRICULA (
CODIGO_MATRICULA
);

/*==============================================================*/
/* Index: MATRICULACURSO_FK                                     */
/*==============================================================*/
create  index MATRICULACURSO_FK on MATRICULA (
CODIGO_CURSO
);

/*==============================================================*/
/* Index: MATRICULAALUNO_FK                                     */
/*==============================================================*/
create  index MATRICULAALUNO_FK on MATRICULA (
CODIGO_ALUNO
);

/*==============================================================*/
/* Table: PESSOA                                                */
/*==============================================================*/
create table PESSOA (
CODIGO_PESSOA        INT8                 not null,
CODIGO_ALUNO         INT8                 null,
CODIGO_PROFESSOR     INT8                 null,
CODIGO_ENDERECO      INT8                 null,
CODIGO_FUNCIONARIO   INT8                 null,
NOME_PESSOA          VARCHAR(50)          null,
CPF                  VARCHAR(14)          null,
IDENTIDADE           VARCHAR(14)          null,
TELEFONE             VARCHAR(30)          null,
CELULAR              VARCHAR(50)          null,
DATA_NASCIMENTO      DATE                 null,
EMAIL                VARCHAR(50)          null,
TIPO_PESSOA          CHAR(1)              null,
SEXO                 VARCHAR(50)          null,
OBSERVACAO           TEXT                 null,
NOME_PAI             VARCHAR(50)          null,
NOME_MAE             VARCHAR(50)          null,
NOME_RESPONSAVEL     VARCHAR(50)          null,
constraint PK_PESSOA primary key (CODIGO_PESSOA)
);

/*==============================================================*/
/* Index: PESSOA_PK                                             */
/*==============================================================*/
create unique index PESSOA_PK on PESSOA (
CODIGO_PESSOA
);

/*==============================================================*/
/* Index: PESSOAENDERECO_FK                                     */
/*==============================================================*/
create  index PESSOAENDERECO_FK on PESSOA (
CODIGO_ENDERECO
);

/*==============================================================*/
/* Index: PESSOAFUNCIONARIO_FK                                  */
/*==============================================================*/
create  index PESSOAFUNCIONARIO_FK on PESSOA (
CODIGO_FUNCIONARIO
);

/*==============================================================*/
/* Index: PESSOAALUNO_FK                                        */
/*==============================================================*/
create  index PESSOAALUNO_FK on PESSOA (
CODIGO_ALUNO
);

/*==============================================================*/
/* Index: PESSOAPROFESSOR_FK                                    */
/*==============================================================*/
create  index PESSOAPROFESSOR_FK on PESSOA (
CODIGO_PROFESSOR
);

/*==============================================================*/
/* Table: PROFESSOR                                             */
/*==============================================================*/
create table PROFESSOR (
CODIGO_PROFESSOR     INT8                 not null,
CODIGO_PESSOA        INT8                 not null,
constraint PK_PROFESSOR primary key (CODIGO_PROFESSOR)
);

/*==============================================================*/
/* Index: PROFESSOR_PK                                          */
/*==============================================================*/
create unique index PROFESSOR_PK on PROFESSOR (
CODIGO_PROFESSOR
);

/*==============================================================*/
/* Index: PESSOAPROFESSOR2_FK                                   */
/*==============================================================*/
create  index PESSOAPROFESSOR2_FK on PROFESSOR (
CODIGO_PESSOA
);

/*==============================================================*/
/* Table: TURMA                                                 */
/*==============================================================*/
create table TURMA (
CODIGO_TURMA         INT8                 not null,
CODIGO_CURSO         INT8                 null,
DATA_ABERTURA_INSCRICAO DATE                 null,
DATA_FECHAMENTO_INSCRICAO DATE                 null,
DATA_INICIO          DATE                 null,
DATA_FIM             DATE                 null,
NOME_TURMA           VARCHAR(50)          null,
TURNO_TURMA          VARCHAR(50)          null,
UNIDADE              VARCHAR(50)          null,
CRITERIO_DE_AVALIACAO VARCHAR(100)         null,
VAGAS                CHAR                 null,
HORARIO              VARCHAR(100)         null,
constraint PK_TURMA primary key (CODIGO_TURMA)
);

/*==============================================================*/
/* Index: TURMA_PK                                              */
/*==============================================================*/
create unique index TURMA_PK on TURMA (
CODIGO_TURMA
);

/*==============================================================*/
/* Index: CURSOTURMA_FK                                         */
/*==============================================================*/
create  index CURSOTURMA_FK on TURMA (
CODIGO_CURSO
);

alter table ALUNO
   add constraint FK_ALUNO_CONTRATOA_CONTRATO foreign key (CODIGO_CONTRATO)
      references CONTRATO (CODIGO_CONTRATO)
      on delete restrict on update restrict;

alter table ALUNO
   add constraint FK_ALUNO_PESSOAALU_PESSOA foreign key (CODIGO_PESSOA)
      references PESSOA (CODIGO_PESSOA)
      on delete restrict on update restrict;

alter table CONTRATO
   add constraint FK_CONTRATO_CONTRATOA_ALUNO foreign key (CODIGO_ALUNO)
      references ALUNO (CODIGO_ALUNO)
      on delete restrict on update restrict;

alter table FUNCIONARIO
   add constraint FK_FUNCIONA_PESSOAFUN_PESSOA foreign key (CODIGO_PESSOA)
      references PESSOA (CODIGO_PESSOA)
      on delete restrict on update restrict;

alter table MATRICULA
   add constraint FK_MATRICUL_MATRICULA_ALUNO foreign key (CODIGO_ALUNO)
      references ALUNO (CODIGO_ALUNO)
      on delete restrict on update restrict;

alter table MATRICULA
   add constraint FK_MATRICUL_MATRICULA_CURSO foreign key (CODIGO_CURSO)
      references CURSO (CODIGO_CURSO)
      on delete restrict on update restrict;

alter table PESSOA
   add constraint FK_PESSOA_PESSOAALU_ALUNO foreign key (CODIGO_ALUNO)
      references ALUNO (CODIGO_ALUNO)
      on delete restrict on update restrict;

alter table PESSOA
   add constraint FK_PESSOA_PESSOAEND_ENDERECO foreign key (CODIGO_ENDERECO)
      references ENDERECO (CODIGO_ENDERECO)
      on delete restrict on update restrict;

alter table PESSOA
   add constraint FK_PESSOA_PESSOAFUN_FUNCIONA foreign key (CODIGO_FUNCIONARIO)
      references FUNCIONARIO (CODIGO_FUNCIONARIO)
      on delete restrict on update restrict;

alter table PESSOA
   add constraint FK_PESSOA_PESSOAPRO_PROFESSO foreign key (CODIGO_PROFESSOR)
      references PROFESSOR (CODIGO_PROFESSOR)
      on delete restrict on update restrict;

alter table PROFESSOR
   add constraint FK_PROFESSO_PESSOAPRO_PESSOA foreign key (CODIGO_PESSOA)
      references PESSOA (CODIGO_PESSOA)
      on delete restrict on update restrict;

alter table TURMA
   add constraint FK_TURMA_CURSOTURM_CURSO foreign key (CODIGO_CURSO)
      references CURSO (CODIGO_CURSO)
      on delete restrict on update restrict;


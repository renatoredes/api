/*==============================================================*/
/* Table: ALUNO                                                 */
/*==============================================================*/
create table ALUNO (
CODIGO_ALUNO         INT8                 not null,
CODIGO_PESSOA        INT8                 not null,
CODIGO_CONTRATO      INT8                 null,
constraint PK_ALUNO primary key (CODIGO_ALUNO)
);

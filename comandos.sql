DROP SEQUENCE ACESSO_FUNCIONARIO_SEQ;

DROP SEQUENCE USUARIO_SEQ;

DROP SEQUENCE PROTOCOLO_SEQ;

DROP SEQUENCE RESPOSTA_SEQ;

DROP SEQUENCE ASSUNTO_SEQ;

DROP SEQUENCE SETOR_SEQ;

DROP SEQUENCE MENSAGEM_SEQ;

DROP SEQUENCE CIDADE_SEQ;

DROP TABLE MENSAGEM;

DROP TABLE ACESSO_FUNCIONARIO;

DROP TABLE USUARIO;

DROP TABLE PROTOCOLO;

DROP TABLE RESPOSTA;

DROP TABLE ASSUNTO;

DROP TABLE SETOR;

DROP TABLE CIDADE;


/* cria Sequencia*/

CREATE SEQUENCE ACESSO_FUNCIONARIO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE SEQUENCE USUARIO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

  CREATE SEQUENCE PROTOCOLO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
CREATE SEQUENCE RESPOSTA_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE SEQUENCE ASSUNTO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;  

CREATE SEQUENCE SETOR_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;  
  
CREATE SEQUENCE MENSAGEM_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;  

CREATE SEQUENCE CIDADE_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
 /* Cria a Tabela CIDADE */
 
CREATE TABLE CIDADE 

( 
	CODIGO		NUMERIC(4) NOT NULL PRIMARY KEY,
	DESCRICAO 	VARCHAR(50) NULL,
	PAIS 		VARCHAR(20) NULL,
	ESTADO 		VARCHAR(30) NULL 
); 
  
  
/* Cria a Tabela ACESSO */

CREATE TABLE ACESSO_FUNCIONARIO
( LOGIN				INT			NOT NULL  PRIMARY KEY,
  SENHA				VARCHAR (50)		NOT NULL,
  MATRICULA 		INT 			NOT NULL, 
  NOME 				VARCHAR (50) 		NOT NULL,
  CODIGO			INT				NULL,
  CONSTRAINT ACESSO_FUNCIONARIO_CIDADE_FK 
                FOREIGN KEY (CODIGO) 
                REFERENCES CIDADE(CODIGO)
);
CREATE TABLE USUARIO
( CPF				DECIMAL (11) 	NOT NULL  PRIMARY KEY,
  NOME 				VARCHAR (50) 	NOT NULL,
  DATA_NASCIMENTO 	DATE			NULL,
  ENDERECO      	VARCHAR (50)	NULL,
  EMAIL				VARCHAR (80)    NULL,
  TELEFONE          DECIMAL(11)  NOT NULL,
  SEXO 				CHAR (1) 		NULL 
);

 /* Cria a Tabela PROTOCOLO */
 
 CREATE TABLE PROTOCOLO
( ID						INT  		NOT NULL  PRIMARY KEY,
  NUMERO					INT 		NULL
 );
 
/* Cria a Tabela RESPOSTA */
 
CREATE TABLE RESPOSTA
( ID						INT  			NOT NULL  PRIMARY KEY,
  CONTEUDO 					VARCHAR (20) 	NOT NULL,
  ID_PROTOCOLO				INT				NOT NULL,
  DATA						DATE			NULL
 );
 
  /* Cria a Tabela ASSUNTO */
 
 CREATE TABLE ASSUNTO
( ID						INT  			NOT NULL  PRIMARY KEY,
  ASSUNTO					VARCHAR (50)	NOT NULL
 );  
 
   /* Cria a Tabela SETOR */ 
  
 CREATE TABLE SETOR
( ID						INT  			NOT NULL PRIMARY KEY,
  NOME						VARCHAR (50)	NOT NULL
 );  

 /* Cria a Tabela MENSAGEM */
 
CREATE TABLE MENSAGEM
( ID						INT  		    NOT NULL PRIMARY KEY,
  ID_PROTOCOLO				INT			    NOT NULL,
  ID_ASSUNTO				INT			    NOT NULL,
  ID_SETOR					INT			    NOT NULL,
  CPF						DECIMAL (11) 	NOT NULL,
  LOGIN						INT				NOT NULL, 
  NOME						VARCHAR (50)	NOT NULL,
  DATA_MENSAGEM				DATE			NULL,
  STATUS					VARCHAR (6)		NOT NULL,
  CONTEUDO					VARCHAR (60)	NOT NULL,
  CONSTRAINT MENSAGEM_PROTOCOLO_FK 
                FOREIGN KEY (ID_PROTOCOLO) 
                REFERENCES PROTOCOLO(ID),
   CONSTRAINT MENSAGEM_ASSUNTO_FK               
                FOREIGN KEY (ID_ASSUNTO) 
                REFERENCES ASSUNTO(ID),
   CONSTRAINT MENSAGEM_SETOR_FK 
                FOREIGN KEY (ID_SETOR) 
                REFERENCES SETOR(ID), 
   CONSTRAINT MENSAGEM_USUARIO_FK                 
                FOREIGN KEY (CPF) 
                REFERENCES USUARIO(CPF),
   CONSTRAINT MENSAGEM_ACESSO_FUNCIONARIO_FK                 
                FOREIGN KEY (LOGIN) 
                REFERENCES ACESSO_FUNCIONARIO(LOGIN)
              
  );

--CREATE

INSERT INTO USUARIO (CPF,  NOME, DATA_NASCIMENTO,  ENDERECO, EMAIL, TELEFONE,  SEXO) 
VALUES (03275896989 , 'Jairo Junior', '08/07/1991', 'Rua Estrada das Olarias' ,'jra@yahoo.com.br','41996680400', 'M');
 
-- RECOVERY

SELECT CPF, NOME, DATA_NASCIMENTO, ENDERECO, SEXO FROM USUARIO WHERE CPF = 03275896989;

-- UPDATE

UPDATE USUARIO SET NOME = 'Jairo Amauri Abdon Junior', DATA_NASCIMENTO = '08/07/1981', EMAIL='jrabdon@yahoo.com.br', TELEFONE = '41996658997', SEXO = 'M' WHERE CPF=03275896989;

-- SEARCH

SELECT CPF, NOME, DATA_NASCIMENTO, EMAIL, TELEFONE, SEXO FROM USUARIO;


-- DELETE
DELETE FROM MENSAGEM;
DELETE FROM ACESSO_FUNCIONARIO;
DELETE FROM ASSUNTO;
DELETE FROM USUARIO ;
DELETE FROM SETOR ;
DELETE FROM PROTOCOLO;
DELETE FROM CIDADE;
DELETE FROM RESPOSTA;

INSERT INTO CIDADE(CODIGO, DESCRICAO, PAIS, ESTADO) 
VALUES (1, 'São José dos Pinhais', 'Brasil', 'Paraná');

SELECT * FROM MENSAGEM;
SELECT * FROM ACESSO_FUNCIONARIO;
SELECT * FROM ASSUNTO;
SELECT * FROM USUARIO;
SELECT * FROM SETOR;
SELECT * FROM PROTOCOLO;
SELECT * FROM CIDADE;
SELECT * FROM RESPOSTA;
	

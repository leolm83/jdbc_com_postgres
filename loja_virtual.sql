CREATE TABLE PRODUTO (ID SERIAL NOT NULL,NOME VARCHAR(50) NOT NULL,DESCRICAO VARCHAR(255)NOT NULL);
\\para entrar no banco é preciso usar usuarios especificos

sudo -i -u postgres

psql inicia a interface do banco 
\l lista os bancos criados
\c nome_banco \\muda para o banco desejado
\q sai
INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES ('NOTEBOOK','NOTEBOOK SAMSUNG');
INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES ('GELADEIRA','GELADEIRA AZUL');

GRANT CONNECT ON DATABASE loja_virtual TO jdbc1; // usuario: jdbc1 senha: jdbc
GRANT SELECT ON TABLE produto TO jdbc1;
GRANT INSERT ON TABLE produto TO jdbc1;
GRANT DELETE ON TABLE produto to jdbc1;
GRANT USAGE ON SEQUENCE produto_id_seq TO jdbc1;
INSERT INTO CATEGORIA(descricao) VALUES('Informática');
INSERT INTO CATEGORIA(descricao) VALUES('Escritório');

INSERT INTO PRODUTO(nome, valor) VALUES('Computador', 2000.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Impressora', 800.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Mouse', 80.00);

INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(1, 1);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(2, 1);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(2, 2);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(3, 1);

INSERT INTO ESTADO(nome) VALUES('Minas Gerais');
INSERT INTO ESTADO(nome) VALUES('São Paulo');

INSERT INTO CIDADE(id_estado, nome) VALUES(1, 'Uberlandia');
INSERT INTO CIDADE(id_estado, nome) VALUES(2, 'São Paulo');
INSERT INTO CIDADE(id_estado, nome) VALUES(2, 'Campinas');
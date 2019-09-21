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

INSERT INTO CLIENTE(nome, email, cpf_ou_cnpj, tipo) VALUES('Maria Silva', 'maria@gmail.com', '36378912377', 1);

INSERT INTO TELEFONE(id_cliente, telefone) VALUES(1, '27363323');
INSERT INTO TELEFONE(id_cliente, telefone) VALUES(1, '93838393');

INSERT INTO ENDERECO(logradouro, numero, complemento, bairro, cep, id_cliente, id_cidade) VALUES('Rua Flores', '300', 'Apto 303', 'Jardim', '38220834', 1, 1);
INSERT INTO ENDERECO(logradouro, numero, complemento, bairro, cep, id_cliente, id_cidade) VALUES('Avenida Matos', '105', 'Sala 800', 'Centro', '38777012', 1, 2);
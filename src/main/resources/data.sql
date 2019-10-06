INSERT INTO CATEGORIA(nome) VALUES('Informática');
INSERT INTO CATEGORIA(nome) VALUES('Escritório');
INSERT INTO CATEGORIA(nome) VALUES('Cama mesa e banho');
INSERT INTO CATEGORIA(nome) VALUES('Eletrônicos');
INSERT INTO CATEGORIA(nome) VALUES('Jardinagem');
INSERT INTO CATEGORIA(nome) VALUES('Decoração');
INSERT INTO CATEGORIA(nome) VALUES('Perfumaria');

INSERT INTO PRODUTO(nome, valor) VALUES('Computador', 2000.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Impressora', 800.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Mouse', 80.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Mesa de escritório', 300.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Toalha', 50.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Colcha', 200.00);
INSERT INTO PRODUTO(nome, valor) VALUES('TV true color', 1200.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Roçadeira', 800.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Abajour', 100.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Pendente', 180.00);
INSERT INTO PRODUTO(nome, valor) VALUES('Shampoo', 90.00);

INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(1, 1);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(2, 1);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(2, 2);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(3, 1);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(4, 2);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(5, 3);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(6, 3);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(1, 4);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(2, 4);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(3, 4);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(7, 4);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(8, 5);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(9, 6);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(10, 6);
INSERT INTO PRODUTO_CATEGORIA (id_produto, id_categoria) VALUES(11, 7);

INSERT INTO ESTADO(nome) VALUES('Minas Gerais');
INSERT INTO ESTADO(nome) VALUES('São Paulo');

INSERT INTO CIDADE(id_estado, nome) VALUES(1, 'Uberlandia');
INSERT INTO CIDADE(id_estado, nome) VALUES(2, 'São Paulo');
INSERT INTO CIDADE(id_estado, nome) VALUES(2, 'Campinas');

INSERT INTO CLIENTE(nome, email, cpf_ou_cnpj, tipo, senha) VALUES('Maria Silva', 'igorantony@live.com', '36378912377', 1, '$2a$10$2Gc0OsdkaWuo.pgdNlHzV.n.hUe2HsX/gYGWjRde4aQscy6XugC76');
INSERT INTO CLIENTE(nome, email, cpf_ou_cnpj, tipo, senha) VALUES('Igor Antony', 'igor.prohmann@gmail.com', '02378096305', 1, '$2a$10$2Gc0OsdkaWuo.pgdNlHzV.n.hUe2HsX/gYGWjRde4aQscy6XugC76');

INSERT INTO PERFIS(id_cliente, perfis) VALUES(1, 2);

INSERT INTO PERFIS(id_cliente, perfis) VALUES(2, 1);
INSERT INTO PERFIS(id_cliente, perfis) VALUES(2, 2);

INSERT INTO TELEFONE(id_cliente, telefone) VALUES(1, '27363323');
INSERT INTO TELEFONE(id_cliente, telefone) VALUES(1, '93838393');

INSERT INTO TELEFONE(id_cliente, telefone) VALUES(2, '27363323');
INSERT INTO TELEFONE(id_cliente, telefone) VALUES(2, '93838393');

INSERT INTO ENDERECO(logradouro, numero, complemento, bairro, cep, id_cliente, id_cidade) VALUES('Rua Flores', '300', 'Apto 303', 'Jardim', '38220834', 1, 1);
INSERT INTO ENDERECO(logradouro, numero, complemento, bairro, cep, id_cliente, id_cidade) VALUES('Avenida Matos', '105', 'Sala 800', 'Centro', '38777012', 1, 2);

INSERT INTO ENDERECO(logradouro, numero, complemento, bairro, cep, id_cliente, id_cidade) VALUES('Rua Flores', '300', 'Apto 303', 'Jardim', '38220834', 2, 1);

INSERT INTO PEDIDO(instante, id_cliente, id_endereco_de_entrega) VALUES({ts '2017-09-30 10:32:00.00'},  1, 1);
INSERT INTO PEDIDO(instante, id_cliente, id_endereco_de_entrega) VALUES({ts '2017-10-10 19:35:00.00'},  1, 2);

INSERT INTO PAGAMENTO(id_pedido, estado) VALUES(1, 2);
INSERT INTO PAGAMENTO_COM_CARTAO(id_pedido, numero_de_parcelas) VALUES(1,6);

INSERT INTO PAGAMENTO(id_pedido, estado) VALUES(2, 1);
INSERT INTO PAGAMENTO_COM_BOLETO(id_pedido, data_vencimento, data_pagamento) VALUES(2, {ts '2017-10-20 00:00:00.00'}, null);

INSERT INTO ITEM_PEDIDO(id_pedido, id_produto, desconto, quantidade, preco) VALUES(1, 1, 0.00, 1, 2000.00);
INSERT INTO ITEM_PEDIDO(id_pedido, id_produto, desconto, quantidade, preco) VALUES(1, 3, 0.00, 2, 80.00);
INSERT INTO ITEM_PEDIDO(id_pedido, id_produto, desconto, quantidade, preco) VALUES(2, 2, 100.00, 1, 800.00);
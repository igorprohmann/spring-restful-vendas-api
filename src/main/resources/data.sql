INSERT INTO CATEGORIA(nome) VALUES('Informática');
INSERT INTO CATEGORIA(nome) VALUES('Escritório');

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

INSERT INTO PEDIDO(instante, id_cliente, id_endereco_de_entrega) VALUES({ts '2017-09-30 10:32:00.00'},  1, 1);
INSERT INTO PEDIDO(instante, id_cliente, id_endereco_de_entrega) VALUES({ts '2017-10-10 19:35:00.00'},  1, 2);

INSERT INTO PAGAMENTO(id_pedido, estado) VALUES(1, 2);
INSERT INTO PAGAMENTO_COM_CARTAO(id_pedido, numero_de_parcelas) VALUES(1,6);

INSERT INTO PAGAMENTO(id_pedido, estado) VALUES(2, 1);
INSERT INTO PAGAMENTO_COM_BOLETO(id_pedido, data_vencimento, data_pagamento) VALUES(2, {ts '2017-10-20 00:00:00.00'}, null);

INSERT INTO ITEM_PEDIDO(id_pedido, id_produto, desconto, quantidade, preco) VALUES(1, 1, 0.00, 1, 2000.00);
INSERT INTO ITEM_PEDIDO(id_pedido, id_produto, desconto, quantidade, preco) VALUES(1, 3, 0.00, 2, 80.00);
INSERT INTO ITEM_PEDIDO(id_pedido, id_produto, desconto, quantidade, preco) VALUES(2, 2, 100.00, 1, 800.00);
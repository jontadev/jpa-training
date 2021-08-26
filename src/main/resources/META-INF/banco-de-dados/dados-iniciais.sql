-- Table Produto
insert into produto (id, nome, preco, descricao) values (1, "Kindle", 449.0, "Conheca o novo Kindle, agora com a nova versao Plus")
insert into produto (id, nome, preco, descricao) values (3, "Camera GoPro Hero 7", 1440.0, "Desempenho 2x melhor que a ultima versao")

-- Table Cliente
insert into cliente (id, nome) values (1, "Joao da Silva Pereira");
insert into cliente (id, nome) values (2, "Ricardo Seletivo Portugal")

-- Table Pedido
insert into pedido (id, cliente_id, data_pedido, total, status) values (1, 1, sysdate(), 100.0, "AGUARDANDO");

-- Table Item Pedido
insert into item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 5.0, 2);

-- Table Categoria
insert into categoria (id, nome) values (1, "Eletronicos");
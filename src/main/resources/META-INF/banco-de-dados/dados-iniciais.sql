-- Table Produto
insert into produto (id, nome, preco, data_criacao, descricao) values (1, "Kindle", 449.0, date_sub(sysdate(), interval  1 day), "Conheca o novo Kindle, agora com a nova versao Plus")
insert into produto (id, nome, preco, data_criacao, descricao) values (3, "Camera GoPro Hero 7", 1440.0, date_sub(sysdate(), interval  1 day), "Desempenho 2x melhor que a ultima versao")

-- Table Cliente
insert into cliente (id, nome) values (1, "Joao da Silva Pereira");
insert into cliente (id, nome) values (2, "Ricardo Seletivo Portugal")

-- Table Pedido
insert into pedido (id, cliente_id, data_criacao, total, status) values (1, 1, sysdate(), 988.0, "AGUARDANDO");
insert into pedido (id, cliente_id, data_criacao, total, status) values (2, 1, sysdate(), 499.0, "AGUARDANDO");

-- Table Item Pedido
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 499, 2);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (2, 1, 499, 1);

-- Table Pagamento Cartao
insert into pagamento(pedido_id, status, numero_cartao) values (2, "PROCESSANDO", "123", "cartao");

-- Table Categoria
insert into categoria (id, nome) values (1, "Eletronicos");


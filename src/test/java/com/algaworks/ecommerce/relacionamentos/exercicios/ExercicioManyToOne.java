package com.algaworks.ecommerce.relacionamentos.exercicios;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.algaworks.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;

public class ExercicioManyToOne extends EntityManagerTest {

	@Test
	public void relacionamentoManyToOne() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		Produto produto = entityManager.find(Produto.class, 1);

		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setDataCriacao(LocalDateTime.now());
		pedido.setCliente(cliente);
		pedido.setTotal(BigDecimal.TEN);

		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setPedido(pedido);
		itemPedido.setPrecoProduto(BigDecimal.TEN);
		itemPedido.setQuantidade(10);
		itemPedido.setProduto(produto);

		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.persist(itemPedido);
		entityManager.getTransaction().commit();

		entityManager.clear();

		ItemPedido itemPedidoPersistido = entityManager.find(ItemPedido.class, new ItemPedidoId(1,1));
		Assert.assertNotNull(itemPedidoPersistido.getPedido());
		Assert.assertNotNull(itemPedidoPersistido.getProduto());
	}
}

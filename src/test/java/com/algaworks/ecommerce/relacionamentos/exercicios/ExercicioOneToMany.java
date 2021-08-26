package com.algaworks.ecommerce.relacionamentos.exercicios;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.ItemPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import com.algaworks.ecommerce.model.StatusPedido;

public class ExercicioOneToMany extends EntityManagerTest {

	@Test
	public void relacionamentoManyToOne() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		Produto produto = entityManager.find(Produto.class, 1);
		
		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedido.AGUARDANDO);	
		pedido.setDataPedido(LocalDateTime.now());
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
		
		Pedido pedidoPersistido = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertFalse(pedidoPersistido.getItens().isEmpty());
		
	}
}

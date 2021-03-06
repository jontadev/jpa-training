package com.algaworks.ecommerce.relacionamentos;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.PagamentoCartao;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPagamento;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

	@Test
	public void verificarRelacionamento() {
		Pedido pedido = entityManager.find(Pedido.class, 1);
		
		PagamentoCartao pagamentoCartao = new PagamentoCartao();
		pagamentoCartao.setNumero("1234");
		pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
		pagamentoCartao.setPedido(pedido);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pagamentoCartao);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerificacao.getPagamento());
		
		
	}
}

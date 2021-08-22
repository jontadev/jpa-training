package com.algaworks.ecommerce.mapeamentobasico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.EnderecoEntregaPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;

public class MapeamentoObjetoImbutido extends EntityManagerTest {

	@Test
	public void analisarMapeamentoEmbutido() {
		EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
		endereco.setCep("00000-000");
		endereco.setLogradouro("Rua XV de Novembro");
		endereco.setNumero("0123");
		endereco.setBairro("Centro");
		endereco.setCidade("Blumenau");
		endereco.setEstado("SC");
		
		Pedido pedido = new Pedido();
//		pedido.setId(1); Comentado pois estamos utilizando IDENTITY
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(new BigDecimal(1000));
		pedido.setEnderecoEntrega(endereco);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerificacao);
		Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
	}
}

package com.algaworks.ecommerce.relacionamentos.exercicios;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.NotaFiscal;
import com.algaworks.ecommerce.model.Pedido;

public class ExercicioOneToOne extends EntityManagerTest {

	@Test
	public void verificarRelacionamento() {
		Pedido pedido = entityManager.find(Pedido.class, 1);
		
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setDataEmissao(new Date());
		notaFiscal.setXml("Local do XML...");
		notaFiscal.setPedido(pedido);
		
		entityManager.getTransaction().begin();
		entityManager.persist(notaFiscal);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerificacao.getNotaFiscal());
		
		Cliente clienteVerificacao = entityManager.find(Cliente.class, 1);
		Assert.assertFalse(clienteVerificacao.getPedidos().isEmpty());
		
	}
}

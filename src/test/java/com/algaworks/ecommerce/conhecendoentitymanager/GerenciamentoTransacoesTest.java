package com.algaworks.ecommerce.conhecendoentitymanager;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;

public class GerenciamentoTransacoesTest extends EntityManagerTest {

	@Test(expected = Exception.class)
	public void abrirEFecharCancelarTransacao() {
		try {
			entityManager.getTransaction().begin();
			metodeDeNegocio();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}

	}

	private void metodeDeNegocio() {
		Pedido pedido = entityManager.find(Pedido.class, 1);

		if (pedido.getPagamento() == null) {
			throw new RuntimeException("Pedido ainda nao foi pago!");
		} else {
			pedido.setStatus(StatusPedido.PAGO);
		}
	}
}

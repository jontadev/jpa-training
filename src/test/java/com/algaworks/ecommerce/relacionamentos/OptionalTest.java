package com.algaworks.ecommerce.relacionamentos;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;

public class OptionalTest extends EntityManagerTest {
	
	@Test
	public void verificarCompotamento() {
		Pedido pedido = entityManager.find(Pedido.class, 1);
	}

}

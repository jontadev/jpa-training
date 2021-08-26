package com.algaworks.ecommerce.conhecendoentitymanager;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;

public class EstadoECicloDeVidaTest extends EntityManagerTest {

	@Test
	public void analisarEstados() {
//		Categoria categoriaNovo = new Categoria();
		
		Categoria categoriaGerenciada = entityManager.find(Categoria.class, 1);
		
		entityManager.remove(categoriaGerenciada);
		
		entityManager.persist(categoriaGerenciada);
	}
}

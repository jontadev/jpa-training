package com.algaworks.ecommerce.mapeamentobasico;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;

public class EstrategiaChavePrimeiraTest extends EntityManagerTest {

	@Test
	public void testarEstragiaAuto() {
		Categoria categoria = new Categoria();
		categoria.setNome("Eletronicos");
		
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		
		Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
		assertNotNull(categoriaVerificacao);
	}
	
	@Test
	public void testarEstragiaChave() {
		Categoria categoria = new Categoria();
		categoria.setNome("Eletronicos");
		
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		
		Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
		assertNotNull(categoriaVerificacao);
	}
	
	@Test
	public void testarEstragiaTable() {
		Categoria categoria = new Categoria();
		categoria.setNome("Eletronicos");
		
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		
		Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
		assertNotNull(categoriaVerificacao);
	}
	
	@Test
	public void testarEstragiaIdentity() {
		Categoria categoria = new Categoria();
		categoria.setNome("Eletronicos");
		
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		
		Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
		assertNotNull(categoriaVerificacao);
	}
}

package com.algaworks.ecommerce.iniciandocomjpa;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;

public class ExercicioImplementandoCrudTest extends EntityManagerTest {

	@Test
	public void inserir() {
		Cliente cliente = new Cliente();
//		cliente.setId(3); Comentado pois estamos utilizando IDENTITY
		cliente.setNome("José da Silva");
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		// clear hibernate memory in order to execute the select query
		Cliente clientePersistido = entityManager.find(Cliente.class, cliente.getId());
		Assert.assertNotNull(clientePersistido);
		Assert.assertEquals("José da Silva", clientePersistido.getNome());
	}
	
	@Test
	public void buscarPorId() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		Assert.assertNotNull(cliente);
		Assert.assertEquals("Joao da Silva Pereira", cliente.getNome());
	}
	
	@Test
	public void atualizar() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		
		entityManager.getTransaction().begin();
		cliente.setNome("José da Silva");
		entityManager.getTransaction().commit();
		
		// clear hibernate memory in order to execute the select query
		entityManager.clear();
		
		Cliente clientePersistido = entityManager.find(Cliente.class, cliente.getId());
		Assert.assertNotNull(clientePersistido);
		Assert.assertEquals("José da Silva", clientePersistido.getNome());
	}
	
	@Test
	public void remover() {
		Cliente cliente = entityManager.find(Cliente.class, 2);
		
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		
		// clear hibernate memory in order to execute the select query
		entityManager.clear();
		
		Cliente clienteRemovido = entityManager.find(Cliente.class, cliente.getId());
		Assert.assertNull(clienteRemovido);
	}
	
	
	
}

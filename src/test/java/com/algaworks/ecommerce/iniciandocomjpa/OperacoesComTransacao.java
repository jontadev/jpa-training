package com.algaworks.ecommerce.iniciandocomjpa;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;

public class OperacoesComTransacao extends EntityManagerTest {
	
	@Test
	public void impedirOperacaoComBancoDeDados() {
		Produto produto = entityManager.find(Produto.class, 1);
		
		entityManager.detach(produto);
		
		entityManager.getTransaction().begin();
		produto.setNome("Kindle Paperwhite 2 geracao");
		entityManager.getTransaction().commit();
		
		entityManager.clear(); // clear hibernate cache
		
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);
		Assert.assertEquals("Kindle", produtoVerificacao.getNome());
	}
	
	@Test
	public void inserirObjetoComMerge() {
		Produto produto = new Produto();
		
		produto.setId(4);
		produto.setNome("Microfone Rode Videmic");
		produto.setDescricao("A melhor qualidade de som");
		produto.setPreco(new BigDecimal(1000));
		
		entityManager.getTransaction().begin();
		
		entityManager.merge(produto); 
		
		entityManager.getTransaction().commit();
		
		entityManager.clear(); // clear entity manager cache
		
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);
		
	}
	
	@Test
	public void atualizarObjetoGerenciado() {
		Produto produto = entityManager.find(Produto.class, 1);
		
		entityManager.getTransaction().begin();
		produto.setNome("Kindle Paperwhite 2 geracao");
		entityManager.getTransaction().commit();
		
		entityManager.clear(); // clear hibernate cache
		
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);
		Assert.assertEquals("Kindle Paperwhite 2 geracao", produtoVerificacao.getNome());
	}
	
	@Test
	public void atualizarObjeto() {
		Produto produto = new Produto();
		
		produto.setId(1);
		produto.setNome("Kindle Paperwhite");
		produto.setDescricao("Conheca o novo Kindle");
		produto.setPreco(new BigDecimal(599));
		
		entityManager.getTransaction().begin();
		
		entityManager.merge(produto);
		
		entityManager.getTransaction().commit();
		
		entityManager.clear(); // clear hibernate cache
		
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);
		Assert.assertEquals("Kindle Paperwhite", produtoVerificacao.getNome());
	}
	
	@Test
	public void removerObjeto() {
		Produto produto = entityManager.find(Produto.class, 3);
		
		//entityManager.getTransaction().begin();
		
		entityManager.remove(produto);
		
		//entityManager.getTransaction().commit();
		
		Produto produtoVerificacao = entityManager.find(Produto.class, 3);
		Assert.assertNull(produtoVerificacao);
		
		
	}
	
	@Test
	public void inserirOPrimeiroObjeto() {
		Produto produto = new Produto();
		
		produto.setId(2);
		produto.setNome("Camera Canon");
		produto.setDescricao("A melhor defininacao para suas fotos");
		produto.setPreco(new BigDecimal(5000));
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(produto); 
		
		entityManager.getTransaction().commit();
		
		entityManager.clear(); // clear entity manager cache
		
		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);
		
	}
	
	@Test
	public void abrirEFecharAaTransacao() {
		entityManager.getTransaction().begin();
		
//		Produto produto = new Produto();
//		
//		entityManager.persist(produto);
//		entityManager.merge(produto);
//		entityManager.remove(produto);
		
		entityManager.getTransaction().commit();
	}
}

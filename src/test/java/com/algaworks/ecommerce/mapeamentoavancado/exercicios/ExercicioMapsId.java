package com.algaworks.ecommerce.mapeamentoavancado.exercicios;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.PagamentoCartao;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPagamento;
import org.junit.Assert;
import org.junit.Test;

public class ExercicioMapsId extends EntityManagerTest {

    @Test
    public void executarExericicoMapsId() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setNumeroCartao("123");
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();

        entityManager.clear();

        PagamentoCartao pagamentoCartaoVerificacao = entityManager.find(PagamentoCartao.class, pagamentoCartao.getId());
        Assert.assertNotNull(pagamentoCartaoVerificacao);
        Assert.assertEquals(pedido.getId(), pagamentoCartaoVerificacao.getId());
    }
}

package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Test;

import java.math.BigDecimal;

public class ContextoDePersistencia extends EntityManagerTest {

    @Test
    public void usarContextoPersistencia() {
        entityManager.getTransaction().begin();

        Produto produto = entityManager.find(Produto.class, 1);
        produto.setPreco(new BigDecimal(100.00));

        Produto produto2 = new Produto();
        produto2.setNome("Caneca para Café");
        produto2.setPreco(new BigDecimal(10));
        produto2.setDescricao("Boa caneca para Café");
        entityManager.persist(produto2);

        Produto produto3 = new Produto();
        produto3.setNome("Caneca para Chá!");
        produto3.setPreco(new BigDecimal(10));
        produto3.setDescricao("Boa caneca para Chá");
        produto3 = entityManager.merge(produto3);
        produto3.setDescricao("Alterar descricao");

        entityManager.getTransaction().commit();
    }
}

package com.algaworks.ecommerce.mapeamentoavancado;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class PropriedadesTransientTest extends EntityManagerTest {

    @Test
    public void validarPrimeiroNome() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Assert.assertEquals("Joao", cliente.getPrimeiroNome());
    }
}

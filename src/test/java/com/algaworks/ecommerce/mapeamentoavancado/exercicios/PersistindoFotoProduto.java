package com.algaworks.ecommerce.mapeamentoavancado.exercicios;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.mapeamentoavancado.SalvandoArquivosTest;
import com.algaworks.ecommerce.model.Produto;
import org.hibernate.result.Output;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersistindoFotoProduto extends EntityManagerTest {

    @Test
    public void salvarFoto() {
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setFoto(carregarFoto());
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao.getFoto());
        Assert.assertTrue(produtoVerificacao.getFoto().length > 0);

//        OutputStream out = null;
//        try {
//            out = new FileOutputStream(Files.createFile(Paths.get("user.home" + "/nota-fiscal")).toFile());
//            out.write(produto.getFoto());
//        } catch (IOException e) {
//           throw new RuntimeException(e);
//        }

    }

    private static byte[] carregarFoto() {
        try {
            return PersistindoFotoProduto.class.getResourceAsStream("/nota-fiscal.xml").readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

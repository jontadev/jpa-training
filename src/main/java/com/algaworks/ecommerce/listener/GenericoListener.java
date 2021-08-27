package com.algaworks.ecommerce.listener;

import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.service.NotaFiscalService;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GenericoListener {

    @PostLoad
    public void logar(Object obj) {
        System.out.println("Entidade " + obj.getClass().getSimpleName() + " foi carregada!");
    }
}

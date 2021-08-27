package com.algaworks.ecommerce.model;

import lombok.*;

import java.io.Serializable;
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoId implements Serializable {

    @EqualsAndHashCode.Include
    private Integer pedidoId;

    @EqualsAndHashCode.Include
    private Integer produtoId;
}

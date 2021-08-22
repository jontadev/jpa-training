package com.algaworks.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Produto {

	@Id
	@EqualsAndHashCode.Include
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal preco;

}

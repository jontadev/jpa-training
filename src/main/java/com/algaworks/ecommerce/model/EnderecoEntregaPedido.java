package com.algaworks.ecommerce.model;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class EnderecoEntregaPedido {

	private String cep;

	private String logradouro;

	private String numero;

	private String bairro;

	private String cidade;

	private String estado;

	private String complemento;
}
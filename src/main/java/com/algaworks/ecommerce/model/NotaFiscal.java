package com.algaworks.ecommerce.model;

import java.util.Date;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal extends EntidadeBaseInteger {

	@MapsId
	@OneToOne(optional = false)
	@JoinColumn(name = "pedido_id")
//	@JoinTable(name = "pedido_nota_fiscal", 
//			  joinColumns = @JoinColumn(name = "nota_fiscal_id", unique = true)
//			  , inverseJoinColumns = @JoinColumn(name = "pedido_id", unique = true))	
	private Pedido pedido;

	@Lob
	private byte[] xml;

	@Column(name = "data_emissao")
	private Date dataEmissao;
}

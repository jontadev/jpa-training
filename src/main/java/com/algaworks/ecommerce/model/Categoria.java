package com.algaworks.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
//	@SequenceGenerator(name = "seq", sequenceName = "sequencia_chave_primaria")

	//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tabela")
//	@TableGenerator(name = "tabela", table = "hibernate_sequences", 
//					pkColumnName = "sequence_name", 
//					pkColumnValue = "categoria", 
//					valueColumnName = "next_val",
//					initialValue = 0,
//					allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Column(name = "categoria_pai_id")
	private Integer categoriaPaiId;
}

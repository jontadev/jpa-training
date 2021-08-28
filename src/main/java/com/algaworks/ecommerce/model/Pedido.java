package com.algaworks.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.algaworks.ecommerce.listener.GenericoListener;
import com.algaworks.ecommerce.listener.GerarNotaFiscalListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "pedido")
@EntityListeners({GerarNotaFiscalListener.class, GenericoListener.class}) // Listener
public class Pedido extends EntidadeBaseInteger {

	@ManyToOne(optional = false)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
	private List<ItemPedido> itens;
	
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;

	@Column(name = "data_ultima_atualizacao", insertable = false)
	private LocalDateTime dataUltimaAtualicao;
	
	@Column(name = "data_conclusao" , updatable = false)
	private LocalDateTime dataConclusao;
	
	@OneToOne(mappedBy = "pedido")
	private NotaFiscal notaFiscal;
	
	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	@OneToOne(mappedBy = "pedido")
	private Pagamento pagamento;
	
	@Embedded
	private EnderecoEntregaPedido enderecoEntrega;

	public boolean isPago() {
		return StatusPedido.PAGO.equals(status);
	}

	// @PrePersist
	// @PreUpdate
	public void calcularTotal() {
		if (itens != null) {
			total = itens.stream().map(ItemPedido::getPrecoProduto)
					.reduce(BigDecimal.ZERO, BigDecimal::add);
		}
	}

	@PrePersist // será executado ao persistir a entidade
	public void aoPersistir() {
		dataCriacao = LocalDateTime.now();
		calcularTotal();
	}

	@PreUpdate
	public void aoAtualizar() {
		dataUltimaAtualicao = LocalDateTime.now();
		calcularTotal();
	}

	@PreRemove
	public void aoRemover() {
		System.out.println("Antes de remover Pedido");
	}

	@PostRemove
	public void aposRemover() {
		System.out.println("Após remover o Pedido.");
	}

	@PostPersist
	public void aposPersistir() {
		System.out.println("Após persistir o Pedido.");
	}

	@PostUpdate
	public void aposAtualizar() {
		System.out.println("Após Atualizar o Pedido.");
	}

	@PostLoad
	public void aposCarregar() {
		System.out.println("Após carregar o Pedido.");
	}


}

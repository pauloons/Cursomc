package com.alexandre.cursos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;
@Id
@OneToOne
@JoinColumn(name = "pedido_id")
@MapsId

	private Integer id;

	private Estado estadoPagamento;

	private Cliente cliente;

	private Endereco endereco_de_entrega;

	public Pagamento() {
	}
	public Pagamento(Integer id, Estado estadoPagamento, Cliente cliente, Endereco endereco_de_entrega) {
		super();
		this.id = id;
		this.estadoPagamento = estadoPagamento;
		this.cliente = cliente;
		this.endereco_de_entrega = endereco_de_entrega;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

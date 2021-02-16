package com.alexandre.cursos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.alexandre.cursos.domain.enums.Estado_Pagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@JoinColumn(name = "pedido_id")
	@OneToOne
	@MapsId
	private Pedido pedido;

	private Estado_Pagamento estado;

	
	public Pagamento(Integer id, Pedido pedido, Estado_Pagamento estado) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.estado = estado;
	}

	public Pagamento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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

	public Estado_Pagamento getEstado() {
		return estado;
	}

	public void setEstado(Estado_Pagamento estado) {
		this.estado = estado;
	}
}

package com.alexandre.cursos.domain;

import javax.persistence.Entity;

import com.alexandre.cursos.domain.enums.Estado_Pagamento;

@Entity
public class Pagamento_Com_Cartao extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	
	public Pagamento_Com_Cartao(Integer id, Pedido pedido, Estado_Pagamento estado, Integer numeroDeParcelas) {
		super(id, pedido, estado);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Pagamento_Com_Cartao() {
	}

	public Pagamento_Com_Cartao(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

}

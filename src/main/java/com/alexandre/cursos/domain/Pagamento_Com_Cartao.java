package com.alexandre.cursos.domain;

public class Pagamento_Com_Cartao extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	public Pagamento_Com_Cartao() {
	}

	public Pagamento_Com_Cartao(Integer id, Estado estadoPagamento, Cliente cliente, Endereco endereco_de_entrega,
			Integer numeroDeParcelas) {
		super(id, estadoPagamento, cliente, endereco_de_entrega);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

}

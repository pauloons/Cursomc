package com.alexandre.cursos.domain;

import java.util.Date;

public class Pagamento_Com_Boleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;

	private Date data_Vencimento;
	private Date data_Pagamento;
	
	public Pagamento_Com_Boleto() {}

	public Pagamento_Com_Boleto(Integer id, Estado estadoPagamento, Cliente cliente, Endereco endereco_de_entrega,
			                                Date data_Vencimento, Date data_Pagamento) {
		super(id, estadoPagamento, cliente, endereco_de_entrega);
		this.data_Vencimento = data_Vencimento;
		this.data_Pagamento = data_Pagamento;
	
	}

	public Date getData_Vencimento() {
		return data_Vencimento;
	}

	public void setData_Vencimento(Date data_Vencimento) {
		this.data_Vencimento = data_Vencimento;
	}

	public Date getData_Pagamento() {
		return data_Pagamento;
	}

	public void setData_Pagamento(Date data_Pagamento) {
		this.data_Pagamento = data_Pagamento;
	}
	
	
}

package com.alexandre.cursos.domain.enums;

public enum Estado_Pagamento {
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private int cod;
	private String descricao;

	private Estado_Pagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	private Estado_Pagamento() {
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Tipo_Cliente toEnum(Integer id) {

		if (id == null) {
			return null;
		}

		for (Tipo_Cliente x : Tipo_Cliente.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}

package com.alexandre.cursos.domain.enums;

public enum Tipo_Cliente {
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;

	private Tipo_Cliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	private Tipo_Cliente() {
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

package br.com.phellipe.entity.enums;

public enum TipoGenero {

	MASCULINO(1, "Masculino"), FEMININO(2, "Feminino");

	private int cod;
	private String descricao;

	private TipoGenero(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoGenero toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoGenero x : TipoGenero.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}

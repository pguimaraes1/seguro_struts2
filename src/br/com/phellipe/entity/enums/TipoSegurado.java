package br.com.phellipe.entity.enums;

public enum TipoSegurado {

	CORRENTISTA(1, "Sim"), NAOCORRENTISTA(2, "Não");

	private int cod;
	private String descricao;

	private TipoSegurado(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoSegurado toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoSegurado x : TipoSegurado.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Codigo nao encontrado, cod: " + cod);

	}

}

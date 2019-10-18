package br.com.phellipe.entity;

public class SeguradoSeguro {

	private Long idSeguro;
	private Long idSegurado;

	public SeguradoSeguro() {

	}

	public SeguradoSeguro(Long idSeguro, Long idSegurado) {
		this.idSeguro = idSeguro;
		this.idSegurado = idSegurado;
	}

	public Long getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(Long idSeguro) {
		this.idSeguro = idSeguro;
	}

	public Long getIdSegurado() {
		return idSegurado;
	}

	public void setIdSegurado(Long idSegurado) {
		this.idSegurado = idSegurado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SeguradoSeguro [idSeguro=");
		builder.append(idSeguro);
		builder.append(", idSegurado=");
		builder.append(idSegurado);
		builder.append("]");
		return builder.toString();
	}


}

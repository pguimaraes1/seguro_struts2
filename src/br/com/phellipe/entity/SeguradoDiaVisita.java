package br.com.phellipe.entity;

public class SeguradoDiaVisita {

	private Long idSegurado;
	private Long idDia;

	public SeguradoDiaVisita() {
	}

	public SeguradoDiaVisita(Long idSegurado, Long idDia) {
		this.idSegurado = idSegurado;
		this.idDia = idDia;
	}

	public Long getIdSegurado() {
		return idSegurado;
	}

	public void setIdSegurado(Long idSegurado) {
		this.idSegurado = idSegurado;
	}

	public Long getIdDia() {
		return idDia;
	}

	public void setIdDia(Long idDia) {
		this.idDia = idDia;
	}
}



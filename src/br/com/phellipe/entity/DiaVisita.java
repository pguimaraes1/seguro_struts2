package br.com.phellipe.entity;

import java.io.Serializable;

public class DiaVisita implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String dia;

	public DiaVisita() {
	}

	public DiaVisita(Long id, String dia) {
		this.id = id;
		this.dia = dia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

}

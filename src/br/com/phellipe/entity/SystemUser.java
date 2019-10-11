package br.com.phellipe.entity;

import java.io.Serializable;

public class SystemUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String login;
	private String senha;

	public SystemUser(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public SystemUser() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

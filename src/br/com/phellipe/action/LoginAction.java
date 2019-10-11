package br.com.phellipe.action;

import com.opensymphony.xwork2.Action;

import br.com.phellipe.entity.SystemUser;
import br.com.phellipe.persistence.SystemUserPersistence;

public class LoginAction implements Action {

	private String login;
	private String senha;

	@Override
	public String execute() throws Exception {
		SystemUser user = new SystemUser(login, senha);
		SystemUserPersistence rs = new SystemUserPersistence();
		user = rs.loginVerify(user);
		if (user != null) {
			System.out.println("logou!");
			return SUCCESS;
		} else {
			return ERROR;
		}
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

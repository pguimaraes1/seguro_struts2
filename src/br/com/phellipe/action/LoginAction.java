package br.com.phellipe.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import br.com.phellipe.dao.SystemUserDao;
import br.com.phellipe.entity.SystemUser;

public class LoginAction extends ActionSupport implements Action {
	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;

	@Override
	public String execute() throws Exception {
		SystemUser user = new SystemUser(login, senha);
		SystemUserDao rs = new SystemUserDao();
		user = rs.loginVerify(user);
		if (user != null) {
			System.out.println("logou!");
			return SUCCESS;
		} else {
			System.out.println("caiu no erro");
			addActionError(getText("error.login"));
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

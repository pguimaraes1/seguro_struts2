package br.com.phellipe.action.seguro;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.Action;

import br.com.phellipe.entity.Seguro;
import br.com.phellipe.persistence.SeguroPersistence;

public class CadastroSeguroAction implements Action {
	
	private static HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		try {
			Seguro seguro = new Seguro();
			seguro.setNome(request.getParameter("name"));
			seguro.setValor(Double.valueOf(request.getParameter("price")));
			if (seguro != null) {
				SeguroPersistence segpers = new SeguroPersistence();
				segpers.create(seguro);
				request.setAttribute("seguro", seguro);
			}
			return SUCCESS;
		} catch (Exception e) {
			request.setAttribute("msg", "Erro ao gravar!");
			return ERROR;
		}
	}

}

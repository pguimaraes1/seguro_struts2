package br.com.phellipe.action.seguro;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.Action;

import br.com.phellipe.entity.Seguro;
import br.com.phellipe.persistence.SeguroPersistence;

public class UpdateSeguroAction implements Action {
	
	private static HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		try {
			Seguro seguro = new Seguro();
				
			String nome = request.getParameter("nome");
			String valor = request.getParameter("valor");
			String idparam = request.getParameter("id");
			
			SeguroPersistence dao = new SeguroPersistence();
			
			Long id = Long.valueOf(idparam);
			seguro = dao.findById(id);
			
			seguro.setNome(nome);
			seguro.setValor(Double.valueOf(valor));
			
			dao.update(seguro);
			
				return SUCCESS;
			}
		 catch (Exception e) {
			request.setAttribute("msg", "Erro ao gravar!");
			return ERROR;
		}
	}

}

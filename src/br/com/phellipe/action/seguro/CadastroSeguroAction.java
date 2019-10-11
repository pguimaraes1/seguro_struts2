package br.com.phellipe.action.seguro;

import com.opensymphony.xwork2.Action;

import br.com.phellipe.entity.Seguro;
import br.com.phellipe.persistence.SeguroPersistence;

public class CadastroSeguroAction implements Action {

	private Double valor;
	private String nome;

	@Override
	public String execute() throws Exception {

		try {
			Seguro seguro = new Seguro(nome, valor);
			if (seguro != null) {
				SeguroPersistence segpers = new SeguroPersistence();
				segpers.create(seguro);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

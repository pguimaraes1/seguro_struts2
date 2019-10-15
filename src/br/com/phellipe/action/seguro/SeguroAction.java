package br.com.phellipe.action.seguro;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.phellipe.entity.Seguro;
import br.com.phellipe.persistence.SeguroPersistence;

public class SeguroAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String nomeSeguro;
	private Double valorSeguro;
	private Long id;
	private Seguro seguro;
	SeguroPersistence dao = new SeguroPersistence();
	private List<Seguro> seguros = new ArrayList<Seguro>();

	@Override
	public String execute() throws Exception {
		System.out.println("execute 1");
		try {
			this.seguro = new Seguro(nomeSeguro, valorSeguro);
			System.out.println("populou sem id");
			if (this.seguro.getId() == null) {
				System.out.println("Salvando seguro");
				dao.create(this.seguro);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String list() throws Exception {
		try {
			setSeguros(dao.findAll());
			System.out.println("Listando seguro");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

	}

	public String delete() throws Exception {

		try {
			dao.delete(id);
			System.out.println("deletanto...");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("Erro no delete");
			e.printStackTrace();
			return ERROR;
		}
	}

	public String find() throws Exception {
		try {
			this.seguro = dao.findById(id);
			nomeSeguro = this.seguro.getNome();
			valorSeguro = this.seguro.getValor();
			System.out.println(this.seguro);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String update() throws Exception {
		try {
			this.seguro = dao.findById(id);
			System.out.println("buscou");
			if (this.seguro != null) {
				this.seguro = new Seguro(id, nomeSeguro, valorSeguro);
				dao.update(this.seguro);
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return INPUT;
	}

	public Double getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(Double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public String getNomeSeguro() {
		return nomeSeguro;
	}

	public void setNomeSeguro(String nomeSeguro) {
		this.nomeSeguro = nomeSeguro;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

package br.com.phellipe.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.phellipe.action.services.SeguroService;
import br.com.phellipe.dao.SeguroDao;
import br.com.phellipe.entity.Seguro;

public class SeguroAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String nomeSeguro;
	private Double valorSeguro;
	private Long id;
	private Seguro seguro;
	SeguroDao dao = new SeguroDao();
	private List<Seguro> seguros = new ArrayList<Seguro>();

	SeguroService service = new SeguroService();

	
	public String execute() throws Exception {
		System.out.println("execute 1");
		try {
			this.seguro = new Seguro(nomeSeguro, valorSeguro);
			service.create(this.seguro);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String list() throws Exception {
		try {
			setSeguros(service.findAll());
			System.out.println("Listando seguro");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

	}

	public String delete() throws Exception {

		try {
			service.delete(id);
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
			this.seguro = service.find(id);
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
			service.update(id, nomeSeguro, valorSeguro);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
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

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

}

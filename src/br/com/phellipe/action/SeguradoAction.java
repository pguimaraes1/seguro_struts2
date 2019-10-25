package br.com.phellipe.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.phellipe.action.services.SeguradoService;
import br.com.phellipe.action.services.SeguroService;
import br.com.phellipe.dao.DiaVisitaDao;
import br.com.phellipe.entity.DiaVisita;
import br.com.phellipe.entity.Segurado;
import br.com.phellipe.entity.Seguro;
import br.com.phellipe.entity.enums.TipoGenero;
import br.com.phellipe.entity.enums.TipoSegurado;

public class SeguradoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Segurado segurado;
	private Seguro seguro;
	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private Integer tipo;
	private Integer genero;
	private Date dataCadastro;
	private Date dataAlteracao;
	private Date dataNascimento; 
	
	private List<Seguro> seguros = new ArrayList<Seguro>();
	private List<DiaVisita> dias = new ArrayList<DiaVisita>();
	
	private  List<TipoGenero> generos;
	
	private  List<TipoSegurado> tipos;
	private TipoSegurado tiposeg;
	
	private SeguradoService seguradoService = new SeguradoService();
	private SeguroService seguroService = new SeguroService();
	private DiaVisitaDao diaVisitaDao = new DiaVisitaDao();


	public String salvarSegurado() throws Exception {
		try {
			Segurado segurado = new Segurado(id, nome, cpf, rg, tipo, genero, dataNascimento);
			seguradoService.create(segurado, seguros, dias);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String LoadSeguradoForm() throws Exception {
		try {
			generos = Arrays.asList(TipoGenero.values());
			tipos = Arrays.asList(TipoSegurado.values());
			seguros = seguroService.findAll();
			dias = diaVisitaDao.findAll();
			System.out.println(dias);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getGenero() {
		return genero;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	public List<DiaVisita> getDias() {
		return dias;
	}

	public void setDias(List<DiaVisita> dias) {
		this.dias = dias;
	}

	public List<TipoGenero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<TipoGenero> generos) {
		this.generos = generos;
	}

	public List<TipoSegurado> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoSegurado> tipos) {
		this.tipos = tipos;
	}
	
	public Integer getDefaultGeneroValue(){
		return 1;
	}
	
	public Integer getDefaultTipoValue(){
		return 1;
	}
	
	public Seguro getDefaultSeguroValue(){
		
		Seguro seguro = seguroService.find(1l); 
		
		return seguro;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public TipoSegurado getTiposeg() {
		return tiposeg;
	}

	public void setTiposeg(TipoSegurado tiposeg) {
		this.tiposeg = tiposeg;
	}
}

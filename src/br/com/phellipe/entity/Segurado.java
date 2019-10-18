package br.com.phellipe.entity;

import java.io.Serializable;
import java.util.Date;

import br.com.phellipe.entity.enums.TipoGenero;
import br.com.phellipe.entity.enums.TipoSegurado;

public class Segurado implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private Integer tipo;
	private Integer genero;
	private Date dataCadastro;
	private Date dataAlteracao;
	private Date dataNascimento;

	public Segurado(Long id, String nome, String cpf, String rg, TipoSegurado tipo, TipoGenero genero,
			Date dataCadastro, Date dataAlteracao, Date dataNascimento) {
		this.id = (id == null) ? null : id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.tipo = tipo.getCod();
		this.genero = genero.getCod();
		this.dataCadastro = dataCadastro;
		this.dataAlteracao = dataAlteracao;
		this.dataNascimento = dataNascimento;
	}

	

	public Segurado(String nome, String cpf, String rg, Integer tipo, Integer genero) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.tipo = tipo;
		this.genero = genero;
	}

	public Segurado() {
		// TODO Auto-generated constructor stub
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

	public TipoSegurado getTipo() {
		return TipoSegurado.toEnum(tipo);
	}

	public void setTipo(TipoSegurado tipoSegurado) {
		this.tipo = tipoSegurado.getCod();
	}

	public TipoGenero getGenero() {
		return TipoGenero.toEnum(genero);
	}

	public void setGenero(TipoGenero tipoGenero) {
		this.genero = tipoGenero.getCod();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segurado other = (Segurado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("Segurado [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", rg=");
		builder.append(rg);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", dataCadastro=");
		builder.append(dataCadastro);
		builder.append(", dataAlteracao=");
		builder.append(dataAlteracao);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append("]");
		builder.append("\n");
		return builder.toString();
	}
	
	

}

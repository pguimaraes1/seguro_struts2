package br.com.phellipe.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.phellipe.dao.DiaVisitaDao;
import br.com.phellipe.dao.SeguradoDao;

public class SeguradoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	DiaVisitaDao daoDiaVisita = new DiaVisitaDao();
	SeguradoDao daoSegurado = new SeguradoDao();
	

	
}

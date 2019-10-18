package br.com.phellipe.action.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.phellipe.dao.SeguradoDao;
import br.com.phellipe.dao.SeguradoDiaVisitaDao;
import br.com.phellipe.dao.SeguradoSeguroDao;
import br.com.phellipe.dao.SeguroDao;
import br.com.phellipe.entity.Segurado;
import br.com.phellipe.entity.SeguradoDiaVisita;
import br.com.phellipe.entity.SeguradoSeguro;

public class SeguradoService {
	
	SeguradoDao seguradoDao = new SeguradoDao();
	SeguroDao seguroDao = new SeguroDao();
	SeguradoSeguroDao seguradoSeguroDao = new SeguradoSeguroDao();
	SeguradoDiaVisitaDao seguradoDiaVisitaDao = new SeguradoDiaVisitaDao();
	
	public void create(Segurado segurado, String[] id_seguros, String[] id_dias) {
		
		try {
			seguradoDao.create(segurado);
			Long idSegurado = segurado.getId();
			System.out.println(idSegurado);
			
			for (String id : id_seguros) {
				Long idSegruoLong = Long.parseLong(id);
				System.out.println("id seguro: " + id);
				SeguradoSeguro ss = new SeguradoSeguro(idSegruoLong, idSegurado);
				seguradoSeguroDao.create(ss);
			}
			
			for (String id : id_dias) {
				Long idDiaLong = Long.parseLong(id);
				System.out.println("id seguro: " + idDiaLong);
				SeguradoDiaVisita sd = new SeguradoDiaVisita( idSegurado, idDiaLong);
				seguradoDiaVisitaDao.create(sd);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SeguradoService service = new SeguradoService();
		String[] dias = {"1", "2"};
		String[] seguros = {"1", "2"};
		Segurado s = new Segurado("Sander", "2133121", "123123", 1, 1);
		s.setDataNascimento(sdf.parse("25/04/1998"));
		service.create(s, seguros, dias);
		
	}
	

}

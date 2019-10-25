package br.com.phellipe.action.services;

import java.text.ParseException;
import java.util.List;

import br.com.phellipe.dao.SeguradoDao;
import br.com.phellipe.dao.SeguradoDiaVisitaDao;
import br.com.phellipe.dao.SeguradoSeguroDao;
import br.com.phellipe.dao.SeguroDao;
import br.com.phellipe.entity.DiaVisita;
import br.com.phellipe.entity.Segurado;
import br.com.phellipe.entity.SeguradoDiaVisita;
import br.com.phellipe.entity.SeguradoSeguro;
import br.com.phellipe.entity.Seguro;

public class SeguradoService {
	
	SeguradoDao seguradoDao = new SeguradoDao();
	SeguroDao seguroDao = new SeguroDao();
	SeguradoSeguroDao seguradoSeguroDao = new SeguradoSeguroDao();
	SeguradoDiaVisitaDao seguradoDiaVisitaDao = new SeguradoDiaVisitaDao();
	
	public void create(Segurado segurado, List<Seguro> seguros, List<DiaVisita> dias) {
		
		try {
			seguradoDao.create(segurado);
			Long idSegurado = segurado.getId();
			System.out.println(idSegurado);
			
			for (Seguro seguro : seguros) {
				System.out.println("id seguro: " + seguro.getId());
				SeguradoSeguro ss = new SeguradoSeguro(seguro.getId(), idSegurado);
				seguradoSeguroDao.create(ss);
			}
			
			for (DiaVisita dia : dias) {
				System.out.println("id seguro: " + dia.getId());
				SeguradoDiaVisita sd = new SeguradoDiaVisita( idSegurado, dia.getId());
				seguradoDiaVisitaDao.create(sd);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		SeguradoService service = new SeguradoService();
//		String[] dias = {"1", "2"};
//		String[] seguros = {"1", "2"};
//		Segurado s = new Segurado("Sander", "2133121", "123123", 1, 1);
//		s.setDataNascimento(sdf.parse("25/04/1998"));
//		//service.create(s, seguros, dias);
		
	}
	

}

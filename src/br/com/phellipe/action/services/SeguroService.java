package br.com.phellipe.action.services;

import java.util.List;

import br.com.phellipe.dao.SeguroDao;
import br.com.phellipe.entity.Seguro;

public class SeguroService {

	SeguroDao dao = new SeguroDao();

	public void create(Seguro seguro) {
		try {
			if (seguro.getId() == null) {
			System.out.println("Salvando seguro");
			dao.create(seguro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Seguro> findAll() {
		List<Seguro> seguros = dao.findAll();
		return seguros;
	}
	
	public Seguro find(Long id) {
		try {
			Seguro seguro = dao.findById(id);
			return seguro;
		} catch (Exception e) {
			throw new IllegalArgumentException("id nao encontrado: " + id);
		}
	}
	
	public void update(Long id, String nomeSeguro, Double valorSeguro) {
		try {
			Seguro seguro;
			seguro = dao.findById(id);
		System.out.println("buscou");
		if (seguro != null) {
			seguro = new Seguro(id, nomeSeguro, valorSeguro);
			dao.update(seguro);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Long id) {
		try {
			dao.delete(id);
		} catch (Exception e) {
			throw new IllegalArgumentException("erro ao excluir o id " + id );
		}
	}
	
}

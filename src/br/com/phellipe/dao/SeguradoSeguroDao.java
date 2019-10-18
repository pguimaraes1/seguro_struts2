package br.com.phellipe.dao;

import java.util.List;

import br.com.phellipe.entity.SeguradoSeguro;

public class SeguradoSeguroDao extends Dao implements IDao<SeguradoSeguro>{

	@Override
	public void create(SeguradoSeguro obj) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("insert into segurados_seguros values (?, ?)");
			stmt.setLong(1, obj.getIdSegurado());
			stmt.setLong(2, obj.getIdSeguro());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}		
	}

	@Override
	public SeguradoSeguro findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeguradoSeguro> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SeguradoSeguro obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

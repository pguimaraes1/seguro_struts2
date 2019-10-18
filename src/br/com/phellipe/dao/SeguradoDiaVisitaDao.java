package br.com.phellipe.dao;

import java.util.List;

import br.com.phellipe.entity.SeguradoDiaVisita;

public class SeguradoDiaVisitaDao extends Dao implements IDao<SeguradoDiaVisita> {

	@Override
	public void create(SeguradoDiaVisita obj) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("insert into segurados_diasvisita values (?, ?)");
			stmt.setLong(1, obj.getIdSegurado());
			stmt.setLong(2, obj.getIdDia());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	@Override
	public SeguradoDiaVisita findById(Long id) throws Exception {
		return null;
	}

	@Override
	public List<SeguradoDiaVisita> findAll() throws Exception {
		return null;
	}

	@Override
	public void update(SeguradoDiaVisita obj) throws Exception {

	}

	@Override
	public void delete(Long id) throws Exception {

	}

}

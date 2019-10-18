package br.com.phellipe.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.phellipe.entity.DiaVisita;

public class DiaVisitaDao extends Dao implements IDao<DiaVisita>{

	@Override
	public void create(DiaVisita obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DiaVisita findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiaVisita> findAll() throws Exception {
		try {
			open();
			List<DiaVisita> dias = new ArrayList<DiaVisita>();
			stmt = con.prepareStatement("select * from dias");
			rs = stmt.executeQuery();
			while (rs.next()) {
				DiaVisita dia = new DiaVisita();
				dia.setId(rs.getLong(1));
				dia.setDia(rs.getString(2));
				dias.add(dia);
			}
			return dias;
		} catch (Exception e) {
			return null;
		} finally {
			con.close();
		}
	}
	
	@Override
	public void update(DiaVisita obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

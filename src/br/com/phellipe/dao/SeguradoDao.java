package br.com.phellipe.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.phellipe.entity.Segurado;
import br.com.phellipe.entity.enums.TipoGenero;
import br.com.phellipe.entity.enums.TipoSegurado;

public class SeguradoDao extends Dao implements IDao<Segurado> {

	@SuppressWarnings("static-access")
	@Override
	public void create(Segurado obj) throws Exception {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			open();
			System.out.println("abrindo conexao");
			stmt = con.prepareStatement("insert into segurados values (null, ?, ?, ?, ? , ?, ?, ?, ?)",  stmt.RETURN_GENERATED_KEYS );
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getRg());
			stmt.setString(3, obj.getCpf());
			stmt.setInt(4, obj.getGenero().getCod());
			stmt.setInt(5, obj.getTipo().getCod());
			stmt.setDate(6, new Date(obj.getDataNascimento().getTime()));
			stmt.setString(7, fmt.format(new Timestamp(new java.util.Date().getTime())));
			stmt.setString(8, fmt.format(new Timestamp(new java.util.Date().getTime())));
			stmt.execute();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				obj.setId(generatedKeys.getLong(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Fechando");
			con.close();
		}
	}

	@Override
	public Segurado findById(Long id) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("select * from segurados where id_segurado = ?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			Segurado seg = null;
			if (rs.next()) {
				seg = new Segurado();
				seg.setId(rs.getLong(1));
				seg.setNome(rs.getString(2));
				seg.setRg(rs.getString(3));
				seg.setCpf(rs.getString(4));
				seg.setGenero(TipoGenero.toEnum(rs.getInt(5)));
				seg.setTipo(TipoSegurado.toEnum(rs.getInt(6)));
				seg.setDataNascimento(rs.getDate(7));
				seg.setDataAlteracao(rs.getTimestamp(8));
				seg.setDataCadastro(rs.getTimestamp(9));
			}
			return seg;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}
	}

	@Override
	public List<Segurado> findAll() throws Exception {
		try {
			open();
			List<Segurado> segurados = new ArrayList<Segurado>();
			stmt = con.prepareStatement("select * from segurados");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Segurado seg = new Segurado();
				seg = new Segurado();
				seg.setId(rs.getLong(1));
				seg.setNome(rs.getString(2));
				seg.setRg(rs.getString(3));
				seg.setCpf(rs.getString(4));
				seg.setGenero(TipoGenero.toEnum(rs.getInt(5)));
				seg.setTipo(TipoSegurado.toEnum(rs.getInt(6)));
				seg.setDataNascimento(rs.getDate(7));
				seg.setDataAlteracao(rs.getTimestamp(8));
				seg.setDataCadastro(rs.getTimestamp(9));
				segurados.add(seg);
			}
			return segurados;
			
		} catch (Exception e) {
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Segurado obj) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("update segurados set nome=?, sexo=?, tipoSegurado=?, dataNascimento=?, dataAlteracao=? where id_segurado=?");
			stmt.setString(1, obj.getNome());
			stmt.setInt(2, obj.getGenero().getCod());
			stmt.setInt(3, obj.getTipo().getCod());
			stmt.setDate(4, new Date(obj.getDataNascimento().getTime()));
			stmt.setTimestamp(5, new Timestamp(new java.util.Date().getTime()));
			stmt.setLong(6, obj.getId());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	
	@Override
	public void delete(Long id) throws Exception {
		try {
			open();
			stmt = con.prepareStatement("delete from segurados where id_segurado=?");
			stmt.setLong(1, id);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		SeguradoDao dao = new SeguradoDao();
//		Segurado s = new Segurado("phellipe", "15313", "1111111", 1, 2);
//		s.setDataNascimento(sdf.parse("25/04/1998"));
//		dao.create(s);
//		
//		
//		Segurado seg = dao.findById(1l);
//				seg.setNome("aaaaaaaaaa");
//		dao.update(seg);
//		
//		System.out.println(dao.findAll());
	}
	
}
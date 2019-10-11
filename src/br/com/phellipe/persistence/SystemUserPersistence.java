package br.com.phellipe.persistence;

import java.sql.SQLException;

import br.com.phellipe.entity.SystemUser;

public class SystemUserPersistence extends Dao {

	public SystemUser loginVerify(SystemUser user) throws SQLException {
		try {
			open();
			stmt = con.prepareStatement("select * from usuarios where username = ? and password = ?");
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getSenha());
			rs = stmt.executeQuery();
			SystemUser userVerified = null;
			if (rs.next()) {
				userVerified = new SystemUser();
				userVerified.setId(rs.getLong(1));
				userVerified.setLogin(rs.getString(2));
				userVerified.setSenha(rs.getString(3));
			} 
			
			return userVerified;
	
		} catch (Exception e) {
			System.out.println("Erro na verificação de login");
			e.printStackTrace();
			return null;

		} finally {
			System.out.println("fechando conexao");
			close();
		}

	}
}

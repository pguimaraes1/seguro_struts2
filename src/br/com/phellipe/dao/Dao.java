package br.com.phellipe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/seguros2?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "bmnc!@@!#@2019";
	
	public void open() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() throws SQLException{
		con.close();
	}
}

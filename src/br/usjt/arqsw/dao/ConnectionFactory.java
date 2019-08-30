package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws IOException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servicedesk?"
					+ "verifyServerCertificate=false&useSSL=true&useTimezone=true"
					+ "&serverTimezone=America/Sao_Paulo"
					+ "&user=root"
					+ "&password=");
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return conn;
	}
}

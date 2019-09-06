package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

@Repository
public class UsuarioDAO {
	
	private Connection conn;
	
	@Autowired
	public UsuarioDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	
	public boolean validar(Usuario usuario) {
		String sqlSelect = "SELECT username, password FROM usuario "
				+ "WHERE username = ? and password = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, usuario.getUsername());
			stm.setString(2, usuario.getPassword());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return false;
	}
}
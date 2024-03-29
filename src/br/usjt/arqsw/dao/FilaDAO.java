package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;

@Repository
public class FilaDAO {

	private Connection conn;
	
	@Autowired
	public FilaDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	
	public ArrayList<Fila> listarFilas() throws IOException {
		String query = "select id_fila, nm_fila from fila";
		ArrayList<Fila> lista = new ArrayList<>();
		try(PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();){
			
			while(rs.next()) {
				Fila fila = new Fila();
				fila.setId(rs.getInt("id_fila"));
				fila.setNome(rs.getString("nm_fila"));
				lista.add(fila);
			}
			
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}

	public Fila pesquisar(int id) {
		Fila fila = new Fila();
		fila.setId(id);
		String sqlInsert = "SELECT * FROM fila WHERE id_fila = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, fila.getId());
			stm.execute();
			try (ResultSet rs = stm.executeQuery();) {
				/*
				 * este outro try e' necessario pois nao da' para abrir o resultsetno anterior
				 * uma vez que antes era preciso configurar o parametrovia setInt; se nao fosse,
				 * poderia se fazer tudo no mesmo try
				 */
				while (rs.next()) {
					fila.setId(rs.getInt("id_fila"));
					fila.setNome(rs.getString("nm_fila"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fila;
	}
}

package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

@Repository
public class ChamadoDAO {
	private Connection conn;
	
	@Autowired
	public ChamadoDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	
	
	public ArrayList<Chamado> listarChamado(Fila fila) throws IOException {
		ArrayList<Chamado> lista = new ArrayList<>();
		String query = "select id_chamado, descricao, status, dt_abertura, dt_fechamento, id_fila from chamado WHERE id_fila = ?";
		try (PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setInt(1, fila.getId());
			pst.execute();
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Chamado chamado = new Chamado();
					chamado.setIdChamado(rs.getInt("id_chamado"));
					chamado.setDescricao(rs.getString("descricao"));
					chamado.setStatus(rs.getString("status"));
					chamado.setDtAbertura(new Date(rs.getDate("dt_abertura").getTime()));
					chamado.setDtFechamento(new Date(rs.getDate("dt_fechamento").getTime()));
					chamado.setFila(fila);
					lista.add(chamado);
				}
			}
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}
}

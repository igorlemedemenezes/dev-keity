package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

@Service
public class ChamadoService {
	
	private ChamadoDAO dao;
	
	@Autowired
	public ChamadoService(ChamadoDAO dao) {
		this.dao = dao;
	}
	
	public ArrayList<Chamado> listar(Fila fila) throws IOException{
		return dao.listarChamado(fila);
	}
}

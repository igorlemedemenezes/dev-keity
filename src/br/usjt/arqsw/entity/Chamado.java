package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

public class Chamado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idChamado;
	private String descricao;
	private String status;
	private Date dtAbertura;
	private Date dtFechamento;
	private Fila fila;
	
	public Chamado() {
	}

	public Chamado(int idChamado, String descricao, String status, Date dtAbertura, Date dtFechamento, Fila fila) {
		super();
		this.idChamado = idChamado;
		this.descricao = descricao;
		this.status = status;
		this.dtAbertura = dtAbertura;
		this.dtFechamento = dtFechamento;
		this.fila = fila;
	}

	public int getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}
}

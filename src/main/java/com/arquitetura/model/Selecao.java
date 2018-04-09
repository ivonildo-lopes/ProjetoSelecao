package com.arquitetura.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Selecao implements Serializable {


	private static final long serialVersionUID = 8514423223056722939L;

	private Integer id;

	private Date periodoInicial;

	private Date periodoFinal;

	private String realizador;
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	private List<Local> locais = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public Date getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	public String getRealizador() {
		return realizador;
	}

	public void setRealizador(String realizador) {
		this.realizador = realizador;
	}

	public Selecao(Integer id,Date periodoInicial, Date periodoFinal, String realizador) {
		super();
		this.id = id;
		this.periodoInicial = periodoInicial;
		this.periodoFinal = periodoFinal;
		this.realizador = realizador;
	}
	
	public Selecao() {
		// TODO Auto-generated constructor stub
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}
	
	
	
	

}

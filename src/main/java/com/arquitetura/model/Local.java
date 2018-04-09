package com.arquitetura.model;

import java.io.Serializable;

public class Local implements Serializable {

	private static final long serialVersionUID = -530545882562952914L;

	private Integer id;

	private String nome;

	private String pais;

	private String estado;

	private String cidade;

	private String telefone;

	public Local() {
	}

	public Local(Integer id, String nome, String pais, String estado, String cidade, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

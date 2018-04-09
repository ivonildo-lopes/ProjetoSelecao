package com.arquitetura.model;

import java.io.Serializable;


public class Usuario implements Serializable {


	private static final long serialVersionUID = -2149642504999273115L;

	private Integer id;
	
	private String nome;
	
	private String email;
	
	private Integer idade;
	
	private String cpf;
	
	private String site;
	
	private Sexo sexo;
	
	public Usuario() {
		
	}
	
	public Usuario(Integer id, String nome, String email, Integer idade, String cpf, String site, Sexo sexo,
			String profissao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.cpf = cpf;
		this.site = site;
		this.sexo = sexo;
		this.profissao = profissao;
	}

	private String profissao;
	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}

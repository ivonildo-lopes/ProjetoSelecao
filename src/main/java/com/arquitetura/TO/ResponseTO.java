package com.arquitetura.TO;

public class ResponseTO {

	private String status;
	private Boolean sucesso;
	private Object conteudo;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getSucesso() {
		return sucesso;
	}

	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}

	public Object getConteudo() {
		return conteudo;
	}

	public void setConteudo(Object conteudo) {
		this.conteudo = conteudo;
	}

	public ResponseTO(String status, Boolean sucesso) {
		super();
		this.status = status;
		this.sucesso = sucesso;
	}

	public ResponseTO(String status, Boolean sucesso, Object conteudo) {
		super();
		this.status = status;
		this.sucesso = sucesso;
		this.conteudo = conteudo;
	}
	
	

}

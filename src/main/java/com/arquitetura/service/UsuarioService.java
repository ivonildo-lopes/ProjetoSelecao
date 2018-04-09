package com.arquitetura.service;

import java.util.List;

import com.arquitetura.model.Usuario;


public interface UsuarioService {

	public List<Usuario> findAll(Integer idSelecao);
	
	public Usuario findById(Integer idSelecao, Integer id);
	
	public List<Usuario> insertUpdate(Integer idSelecao, Usuario usuario);
	
	public List<Usuario> remove(Integer idSelecao, Integer id);
	
}

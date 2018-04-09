package com.arquitetura.service;

import java.util.List;

import com.arquitetura.model.Local;
import com.arquitetura.model.Selecao;
import com.arquitetura.model.Usuario;

public interface SelecaoService {

	public List<Selecao> findAll();

	public Selecao findById(Integer id);

	public List<Selecao> inserir(Selecao selecao);

	public List<Selecao> remover(Integer id);

	public List<Selecao> insertUpdateLocal(Integer id, Local local);

	public List<Selecao> removeLocal(Integer id, Integer idLocal);

	public List<Selecao> insertUpdateUsuario(Integer id, Usuario usuario);

	public List<Selecao> removeUsuario(Integer id, Integer idUsuario);

}

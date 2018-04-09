package com.arquitetura.service;

import java.util.List;

import com.arquitetura.model.Local;


public interface LocalService {

	public List<Local> findAll(Integer idSelecao);
	
	public Local findById(Integer idSelecao,Integer id);
	
	public List<Local> insertUpdate(Integer idSelecao, Local local);
	
	public List<Local> remove(Integer idSelecao, Integer id);
	
}

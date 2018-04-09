package com.arquitetura.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitetura.model.Local;
import com.arquitetura.model.Selecao;
import com.arquitetura.service.LocalService;
import com.arquitetura.service.SelecaoService;

@Service
public class LocalServiceImpl implements LocalService {
	
	@Autowired
	SelecaoService selecao;


	public LocalServiceImpl() {

	}

	@Override
	public List<Local> findAll(Integer idSelecao) {
		return selecao.findById(idSelecao).getLocais();
	}

	@Override
	public Local findById(Integer idSelecao, Integer id) {
		try {
			List<Local> lista = this.selecao.findById(idSelecao).getLocais();
			
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId() == id) {
					return lista.get(i);
				}
			}
			return null;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public List<Local> insertUpdate(Integer idSelecao, Local local) {
		Selecao selecao = this.selecao.findById(idSelecao);

		if (selecao != null) {

			boolean achou = false;
			int cod = 0;

			for (int i = 0; i < selecao.getLocais().size(); i++) {
				if (selecao.getLocais().get(i).getId() == local.getId()) {
					achou = true;
					cod = i;
					break;
				}
			}

			if (achou) {
				selecao.getLocais().get(cod).setNome(local.getNome());
				selecao.getLocais().get(cod).setCidade(local.getCidade());
				selecao.getLocais().get(cod).setEstado(local.getEstado());
				selecao.getLocais().get(cod).setPais(local.getPais());
				selecao.getLocais().get(cod).setTelefone(local.getTelefone());
			} else {
				local.setId(this.findAll(idSelecao).size()+1);
				selecao.getLocais().add(local);
			}

		}

		return selecao.getLocais();
	}

	@Override
	public List<Local> remove(Integer idSelecao, Integer id) {
		Selecao selecao = this.selecao.findById(idSelecao);

		if (selecao != null) {

			for (int i = 0; i < selecao.getLocais().size(); i++) {
				if (selecao.getLocais().get(i).getId() == id) {
					selecao.getLocais().remove(i);
				}
			}
		}

		return selecao.getLocais();
	}

	

}

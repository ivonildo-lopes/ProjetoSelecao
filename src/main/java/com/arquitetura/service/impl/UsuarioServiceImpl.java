package com.arquitetura.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitetura.model.Selecao;
import com.arquitetura.model.Usuario;
import com.arquitetura.service.SelecaoService;
import com.arquitetura.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	SelecaoService selecao;

	public UsuarioServiceImpl() {
		
	}

	@Override
	public List<Usuario> findAll(Integer idSelecao) {
		return selecao.findById(idSelecao).getUsuarios();
	}

	@Override
	public Usuario findById(Integer idSelecao,Integer id) {
		try {
			List<Usuario> lista = this.selecao.findById(idSelecao).getUsuarios();
			
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

	public List<Usuario> insertUpdate(Integer idSelecao, Usuario usuario) {
		
		Selecao selecao = this.selecao.findById(idSelecao);

		if (selecao != null) {

			boolean achou = false;
			int cod = 0;

			for (int i = 0; i < selecao.getUsuarios().size(); i++) {
				if (selecao.getUsuarios().get(i).getId() == usuario.getId()) {
					achou = true;
					cod = i;
					break;
				}
			}

			if (achou) {
				selecao.getUsuarios().get(cod).setNome(usuario.getNome());
				selecao.getUsuarios().get(cod).setIdade(usuario.getIdade());
				selecao.getUsuarios().get(cod).setCpf(usuario.getCpf());
				selecao.getUsuarios().get(cod).setEmail(usuario.getEmail());
				selecao.getUsuarios().get(cod).setProfissao(usuario.getProfissao());
				selecao.getUsuarios().get(cod).setSexo(usuario.getSexo());
				selecao.getUsuarios().get(cod).setSite(usuario.getSite());
			} else {
				usuario.setId(this.findAll(idSelecao).size()+1);
				selecao.getUsuarios().add(usuario);
			}

		}

		return selecao.getUsuarios();
		
		

	}

	@Override
	public List<Usuario> remove(Integer idSelecao, Integer id) {
		Selecao selecao = this.selecao.findById(idSelecao);

		if (selecao != null) {

			for (int i = 0; i < selecao.getUsuarios().size(); i++) {
				if (selecao.getUsuarios().get(i).getId() == id) {
					selecao.getUsuarios().remove(i);
				}
			}
		}

		return selecao.getUsuarios();
	}

}

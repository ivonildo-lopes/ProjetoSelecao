package com.arquitetura.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arquitetura.model.Local;
import com.arquitetura.model.Selecao;
import com.arquitetura.model.Usuario;
import com.arquitetura.service.SelecaoService;

@Service
public class SelecaoServiceImpl implements SelecaoService {

	List<Selecao> lista = new ArrayList<>();

	public SelecaoServiceImpl() {
		lista.add(new Selecao(1, new Date(), new Date(), "Antonio Astolfo Ramos da Silva"));
		lista.add(new Selecao(2, new Date(), new Date(), "Ivonildo Lopes"));
		lista.add(new Selecao(3, new Date(), new Date(), "Kassi Ramos"));
		lista.add(new Selecao(4, new Date(), new Date(), "Jose Henry Martins Lopes"));
	}

	@Override
	public List<Selecao> findAll() {
		return lista;
	}

	@Override
	public Selecao findById(Integer id) {
		try {
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

	public List<Selecao> inserir(Selecao selecao) {
		boolean achou = false;
		int id = 0;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == selecao.getId()) {
				achou = true;
				id = i;
				break;
			}
		}

		if (achou) {
			lista.get(id).setPeriodoFinal(selecao.getPeriodoInicial());
			lista.get(id).setPeriodoInicial(selecao.getPeriodoFinal());
			lista.get(id).setRealizador(selecao.getRealizador());
		} else {
			lista.add(selecao);
		}

		return lista;
	}

	@Override
	public List<Selecao> remover(Integer id) {
		Selecao selecao = this.findById(id);
		if (selecao != null) {
			lista.remove(selecao);
		}
		return lista;
	}

	@Override
	public List<Selecao> insertUpdateLocal(Integer id, Local local) {

		Selecao selecao = findById(id);

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
				selecao.getLocais().add(local);
			}

		}

		return lista;
	}

	@Override
	public List<Selecao> removeLocal(Integer id, Integer idLocal) {

		Selecao selecao = this.findById(id);

		if (selecao != null) {

			for (int i = 0; i < selecao.getLocais().size(); i++) {
				if (selecao.getLocais().get(i).getId() == idLocal) {
					selecao.getLocais().remove(i);
				}
			}
		}

		return lista;
	}

	@Override
	public List<Selecao> insertUpdateUsuario(Integer id, Usuario usuario) {
		Selecao selecao = findById(id);

		if (selecao != null) {

			boolean achou = false;
			int cod = 0;

			for (int i = 0; i < selecao.getUsuarios().size(); i++) {
				if (selecao.getUsuarios().get(i).getId() == usuario.getId()) {
					achou = true;
					id = i;
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
				selecao.getUsuarios().add(usuario);
			}

		}

		return lista;
	}

	@Override
	public List<Selecao> removeUsuario(Integer id, Integer idUsuario) {
		Selecao selecao = this.findById(id);

		if (selecao != null) {

			for (int i = 0; i < selecao.getUsuarios().size(); i++) {
				if (selecao.getUsuarios().get(i).getId() == idUsuario) {
					selecao.getUsuarios().remove(i);
				}
			}
		}

		return lista;
	}

}

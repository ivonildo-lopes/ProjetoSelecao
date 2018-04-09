package com.arquitetura.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arquitetura.TO.ResponseTO;
import com.arquitetura.model.Usuario;
import com.arquitetura.service.UsuarioService;

@RestController
@RequestMapping(value = "/selective")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/{idSelecao}/{id}/users", method = RequestMethod.GET)
	public ResponseEntity<ResponseTO> buscarPorId(@PathVariable("idSelecao") Integer idSelecao,
			@PathVariable("id") Integer id) {
		try {
			if (id != null)
				return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.findById(idSelecao, id)),
						HttpStatus.OK);

			return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Informe um usuario"), HttpStatus.OK);

		} catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Não existe"), HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/{idSelecao}/users", method = RequestMethod.GET)
	public ResponseEntity<ResponseTO> findAll(@PathVariable("idSelecao") Integer idSelecao) {
		try {
			return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.findAll(idSelecao)),
					HttpStatus.OK);
		} catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Não existe"), HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/{idSelecao}/user", method = RequestMethod.POST)
	public ResponseEntity<ResponseTO> salvar(@PathVariable("idSelecao") Integer idSelecao,
			@RequestBody Usuario usuario) {
		if (idSelecao != null)
			return new ResponseEntity<ResponseTO>(
					new ResponseTO("Sucesso", true, service.insertUpdate(idSelecao, usuario)), HttpStatus.OK);

		return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Informe um usuario"), HttpStatus.OK);
	}

	@RequestMapping(value = "/{idSelecao}/user", method = RequestMethod.PUT)
	public ResponseEntity<ResponseTO> alterar(@PathVariable("idSelecao") Integer idSelecao, @RequestBody Usuario usuario) {
		if (idSelecao != null)
			return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.insertUpdate(idSelecao,usuario)),
					HttpStatus.OK);

		return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Informe um usuario"), HttpStatus.OK);
	}

	@RequestMapping(value = "/{idSelecao}/{id}/user", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseTO> delete(@PathVariable("idSelecao") Integer idSelecao, @PathVariable("id") Integer id) {
		if (id != null)
			return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.remove(idSelecao,id)), HttpStatus.OK);

		return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Informe um usuario"), HttpStatus.OK);
	}

}

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
import com.arquitetura.model.Local;
import com.arquitetura.service.LocalService;

@RestController
@RequestMapping(value = "/selective")
public class LocalResource {

	@Autowired
	private LocalService service;

	@RequestMapping(value = "/{idSelecao}/{id}/places", method = RequestMethod.GET)
	public ResponseEntity<ResponseTO> buscarPorId(@PathVariable("idSelecao") Integer idSelecao,@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.findById(idSelecao,id)), HttpStatus.OK);
		} catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Não existe"), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/{idSelecao}/places", method = RequestMethod.GET)
	public ResponseEntity<ResponseTO> findAll(@PathVariable("idSelecao") Integer idSelecao) {
		return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.findAll(idSelecao)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{idSelecao}/place", method = RequestMethod.POST)
	public ResponseEntity<ResponseTO> salvar(@PathVariable("idSelecao") Integer idSelecao, @RequestBody Local local) {
		if (idSelecao != null)
			return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.insertUpdate(idSelecao,local)),
					HttpStatus.OK);

		return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Informe um Local"), HttpStatus.OK);
	}

	@RequestMapping(value = "/{idSelecao}/place", method = RequestMethod.PUT)
	public ResponseEntity<ResponseTO> alterar(@PathVariable("idSelecao") Integer idSelecao, @RequestBody Local local) {
		if (idSelecao != null)
			return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.insertUpdate(idSelecao,local)),
					HttpStatus.OK);

		return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Informe um Local"), HttpStatus.OK);
	}

	@RequestMapping(value = "/{idSelecao}/{id}/place", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseTO> delete(@PathVariable("idSelecao") Integer idSelecao,@PathVariable("id") Integer id) {
		if (id != null)
			return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.remove(idSelecao,id)),
					HttpStatus.OK);

		return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Informe um Local"), HttpStatus.OK);
	}
}

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
import com.arquitetura.model.Selecao;
import com.arquitetura.service.SelecaoService;

@RestController
@RequestMapping(value = "/selective")
public class SelecaoResource {

	@Autowired
	private SelecaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponseTO> buscarPorId(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.findById(id)), HttpStatus.OK);
		} catch (IndexOutOfBoundsException e) {
			return new ResponseEntity<ResponseTO>(new ResponseTO("Erro", false, "Não existe"), HttpStatus.OK);
		}

	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<ResponseTO> salvar(@RequestBody Selecao selecao) {
		return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.inserir(selecao)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseTO> delete(@PathVariable("id") Integer id) {
		return new ResponseEntity<ResponseTO>(new ResponseTO("Sucesso", true, service.remover(id)), HttpStatus.OK);
	}

	
}

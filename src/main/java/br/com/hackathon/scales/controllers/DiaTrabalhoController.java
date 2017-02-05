package br.com.hackathon.scales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hackathon.scales.entities.DiaTrabalho;
import br.com.hackathon.scales.services.DiaTrabalhoService;

@RestController
@RequestMapping("/dia_trabalho")
public class DiaTrabalhoController {

	@Autowired
	private DiaTrabalhoService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<DiaTrabalho> save(@Validated DiaTrabalho funcionario, Errors errors) {
		DiaTrabalho saved = service.save(funcionario, errors);

		HttpStatus status = null;

		if (saved.hasErrors()) {
			status = HttpStatus.CONFLICT;
		} else {
			status = HttpStatus.CREATED;
		}

		ResponseEntity<DiaTrabalho> responseEntity = new ResponseEntity<DiaTrabalho>(saved, status);
		return responseEntity;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<DiaTrabalho> findAll() {
		List<DiaTrabalho> todosDiaTrabalho = service.findAll();

		return todosDiaTrabalho;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<DiaTrabalho> findOne(@PathVariable Long id) {
		DiaTrabalho found = service.findOne(id);
		
		ResponseEntity<DiaTrabalho> responseEntity = new ResponseEntity<DiaTrabalho>(found, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

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

import br.com.hackathon.scales.entities.SystemParameter;
import br.com.hackathon.scales.services.SystemParameterService;

@RestController
@RequestMapping("/parametros")
public class SustemParameterController {
	
	@Autowired
	private SystemParameterService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SystemParameter> save(@Validated SystemParameter funcionario, Errors errors) {
		SystemParameter saved = service.save(funcionario, errors);
		
		HttpStatus status = null;
		
		if (saved.hasErrors()) {
			status = HttpStatus.CONFLICT;
		} else {
			status = HttpStatus.CREATED;
		}
		
		ResponseEntity<SystemParameter> responseEntity = new ResponseEntity<SystemParameter>(saved, status);
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<SystemParameter> getAllPoints() {
		List<SystemParameter> todosFuncionarios = service.findAll();
		
		return todosFuncionarios;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.delete(id);		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

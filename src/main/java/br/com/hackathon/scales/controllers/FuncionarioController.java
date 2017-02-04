package br.com.hackathon.scales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.hackathon.scales.entities.Funcionario;
import br.com.hackathon.scales.services.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Funcionario> save(@Validated Funcionario funcionario, Errors errors) {
		Funcionario saved = service.save(funcionario, errors);
		
		HttpStatus status = null;
		
		if (saved.hasErrors()) {
			status = HttpStatus.CONFLICT;
		} else {
			status = HttpStatus.CREATED;
		}
		
		ResponseEntity<Funcionario> responseEntity = new ResponseEntity<Funcionario>(saved, status);
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Funcionario> getAllPoints() {
		List<Funcionario> todosFuncionarios = service.findAll();
		
		return todosFuncionarios;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.delete(id);		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
//	@RequestMapping(method = RequestMethod.PUT)
//	public ResponseEntity<Funcionario> update(@Validated Funcionario funcionario, Errors errors) {
//		
//	}
}

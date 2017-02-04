package br.com.hackathon.scales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.hackathon.scales.entities.Funcionario;
import br.com.hackathon.scales.services.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
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

}

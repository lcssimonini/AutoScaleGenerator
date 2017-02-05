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

import br.com.hackathon.scales.entities.Turno;
import br.com.hackathon.scales.services.TurnoService;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
	
	@Autowired
	private TurnoService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Turno> save(@Validated Turno turno, Errors errors) {
		Turno saved = service.save(turno, errors);
		
		HttpStatus status = null;
		
		if (saved.hasErrors()) {
			status = HttpStatus.CONFLICT;
		} else {
			status = HttpStatus.CREATED;
		}
		
		ResponseEntity<Turno> responseEntity = new ResponseEntity<Turno>(saved, status);
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Turno> getAllPoints() {
		List<Turno> todosTurnos = service.findAll();
		
		return todosTurnos;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		service.delete(id);		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

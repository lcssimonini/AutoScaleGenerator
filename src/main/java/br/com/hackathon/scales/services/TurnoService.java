package br.com.hackathon.scales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import br.com.hackathon.scales.entities.Turno;
import br.com.hackathon.scales.repositories.TurnoRepository;

@Service
public class TurnoService {
	
	@Autowired
	private TurnoRepository repository;
	
	public Turno save(Turno turno, Errors errors) {
		
		if (turno == null) {
			throw new IllegalArgumentException("Não foi passado um turno para ser salvo");
		}

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				turno.addErrorMessage(error.getDefaultMessage());
			}
			return turno;
		}

		return repository.save(turno);
	}
	
	public List<Turno> findAll() {
		List<Turno> todosFuncionarios = repository.findAll();
		
		return todosFuncionarios;
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
}

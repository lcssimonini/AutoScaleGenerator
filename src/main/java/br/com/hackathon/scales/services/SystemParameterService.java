package br.com.hackathon.scales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import br.com.hackathon.scales.entities.SystemParameter;
import br.com.hackathon.scales.repositories.SystemParameterRepository;

@Service
public class SystemParameterService {
	
	@Autowired
	private SystemParameterRepository repository;
	
	public SystemParameter save(SystemParameter funcionario, Errors errors) {
		
		if (funcionario == null) {
			throw new IllegalArgumentException("Não foi passado um parâmetro de sistema para ser salvo");
		}

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				funcionario.addErrorMessage(error.getDefaultMessage());
			}
			return funcionario;
		}

		return repository.save(funcionario);
	}
	
	public List<SystemParameter> findAll() {
		List<SystemParameter> todosFuncionarios = repository.findAll();
		
		return todosFuncionarios;
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
}

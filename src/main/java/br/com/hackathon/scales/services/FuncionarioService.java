package br.com.hackathon.scales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import br.com.hackathon.scales.entities.Funcionario;
import br.com.hackathon.scales.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	
	public Funcionario save(Funcionario funcionario, Errors errors) {

		if (funcionario == null) {
			throw new IllegalArgumentException("Não foi passado um funcionario para ser salvo");
		}
		
		Funcionario funcionarioBase = null;
		
		if (funcionario.getId() != null && funcionario.getTurno() != null) {
			funcionarioBase = repository.getOne(funcionario.getId());
			
			funcionarioBase.setTurno(funcionario.getTurno());
			return repository.save(funcionarioBase);
		}

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				funcionario.addErrorMessage(error.getDefaultMessage());
			}
			return funcionario;
		}

		return repository.save(funcionario);
	}
	
	public Funcionario findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Funcionario> findAll() {
		List<Funcionario> todosFuncionarios = repository.findAll();

		return todosFuncionarios;
	}

	public void delete(Long id) {
		repository.delete(id);
	}
}
